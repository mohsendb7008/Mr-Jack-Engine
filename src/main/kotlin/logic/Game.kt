package logic

import exception.GameFinishedException
import model.*
import mu.KLogger
import qa.*
import qa.action.*
import toPair

object Game {

    var turn: Int = 1
    val round: Int
        get() = (turn - 1) / 4 + 1
    val Jack: Character by lazy { Character.values().random() }
    private val cards: MutableList<Character> by lazy { CardDealer.deal().toMutableList() }

    val isJackVisible: Boolean get() = Jack.isVisible
    val visibleCharacters: List<Character> get() = Character.values().filter { it.isVisible }
    val invisibleCharacters: List<Character> get() = Character.values().filterNot { it.isVisible }
    val suspectCharacters: List<Character> get() = Character.values().filter { it.isSuspect }
    val innocentCharacters: List<Character> get() = Character.values().filterNot { it.isSuspect }

    private fun nextCycle() {
        turn = turn % 4 + 1
    }

    private val endOfCycles: Boolean
        get() = round !in 1..8

    val playerTurn: Role
        get() = if ((round % 2 == 0) xor (turn in arrayOf(1, 4))) Role.Jack else Role.Sherlock

    private val deckOfCards: List<Character>
        get() {
            if (cards.isEmpty()) {
                cards += CardDealer.deal()
            }
            return cards
        }

    private fun popFromDeckOfCards(character: Character) {
        cards.remove(character)
    }

    private lateinit var playerOfJack: Player
    private lateinit var playerOfSherlock: Player
    private lateinit var logger: KLogger

    fun init(playerOfJack: Player, playerOfSherlock: Player, logger: KLogger) {
        this.playerOfJack = playerOfJack
        this.playerOfSherlock = playerOfSherlock
        this.logger = logger
    }

    private fun handlePlayerEventAction(action: CharacterAction) {
        when (action) {
            is AlfredElyBeachAction ->
                Character.AlfredElyBeach.performAction(StreetSpace.cells[action.metroPlace]!!)
            is CloudRiderAction ->
                Character.CloudRider.performAction(StreetSpace.cells[action.buildingPlace]!!)
            is EdwardSmithAction ->
                Character.EdwardSmith.performAction(PortSpace.cells[action.from]!!, PortSpace.cells[action.to]!!)
            is EmmaGrantAction ->
                Character.MrsEmmaGrant.performAction(StreetSpace.cells[action.parkPlace]!!)
            is FrancisJTumbletyAction ->
                action.characters?.let { (c1, c2) ->
                    Character.FrancisJTumblety.performAction(c1, c2)
                }
            is HowardLatimerAction ->
                Character.LewisHowardLatimer.performAction(StreetSpace.cells[action.gasLightPlace]!!)
            is JamesHCallahanAction ->
                Character.JamesHCallahan.performAction(InvestigationTile.withId(action.id), action.positions.toList().map { StreetSpace.cells[it]!! }.toPair())
            is MonkEastmanAction ->
                throw IllegalStateException("Should be processed earlier.")
        }
    }

    suspend fun run() {
        playerOfJack.send(WhoIsJack(Jack))
        while (!endOfCycles) {
            val player = when (playerTurn) {
                Role.Jack -> playerOfJack
                Role.Sherlock -> playerOfSherlock
            }
            player.send(
                GameTurn(
                    round = round,
                    turn = turn,
                    map = Board.cells.values.toList(),
                    visibilityStatus = if (isJackVisible) VisibilityStatus.Day else VisibilityStatus.Night,
                    remainingCards = deckOfCards
                )
            )
            val response = player.receive()
            if (response is Condemn && playerTurn == Role.Sherlock) {
                if (response.character == Jack) {
                    finish(Role.Sherlock, "Sherlock arrested Jack!")
                } else {
                    finish(Role.Jack, "Sherlock arrested wrong person and Jack escaped!")
                }
            }
            val event = response as PlayerEvent
            popFromDeckOfCards(event.selectedCard)
            if (event.action is MonkEastmanAction) {
                event.action.character.moveTo(Board.cells[event.move]!!)
            }
            else when (event.order) {
                PlayerEvent.EventOrder.ActionFirst -> {
                    handlePlayerEventAction(event.action)
                    event.selectedCard.moveTo(Board.cells[event.move]!!)
                }
                PlayerEvent.EventOrder.MoveFirst -> {
                    event.selectedCard.moveTo(Board.cells[event.move]!!)
                    handlePlayerEventAction(event.action)
                }
            }
            if (playerTurn == Role.Jack) {
                val cell = Jack.cell
                if (cell is LandExit || (cell is PortSpace && cell.hasSteamer)) {
                    finish(Role.Jack, "Jack escaped!")
                }
            }
            event.informantPosition?.let {
                Informant.moveTo(Board.cells[it]!!)
                player.send(Intrusion(Informant.leakInnocent()))
            }
            if (turn == 4) {
                playerOfSherlock.send(MrJackVisibility(isJackVisible))
            }
            nextCycle()
        }
        finish(Role.Jack, "8 rounds have been played and no escape or condemn has happened.")
    }

    suspend fun finish(winner: Role, reason: String, silent: Boolean = false) {
        logger.info(reason)
        logger.info("$winner (${ if (winner == Role.Jack) playerOfJack.username else playerOfSherlock.username }) won!")
        val qa = Winner(winner)
        runCatching {
            playerOfJack.send(qa)
            playerOfJack.close()
        }
        runCatching {
            playerOfSherlock.send(qa)
            playerOfSherlock.close()
        }
        if (!silent) {
            throw GameFinishedException()
        }
    }

}
