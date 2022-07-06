import exception.GameFinishedException
import io.ktor.network.selector.*
import io.ktor.network.sockets.*
import io.ktor.util.logging.*
import kotlinx.coroutines.Dispatchers
import logic.Player
import mu.KotlinLogging
import qa.*
import model.Character
import model.Position
import model.Role
import qa.action.*

fun get(name: String): String {
    print("$name? ")
    return readLine()!!
}

fun getPosition(name: String): Position =
    get("$name (column, row)")
        .split(", ")
        .map { it.toInt() }
        .toPair()
        .let { Position(it.first, it.second) }

fun <T> getListElement(list: List<T>): T =
    list[get("$list index (zero based)").toInt()]

fun getConfirm(name: String): Boolean =
    get("$name (Y/N)") == "Y"

lateinit var role: Role
lateinit var Jack: Character
val innocents = mutableListOf<Character>()

suspend fun main() {
    val logger = KotlinLogging.logger { }
    val selectorManager = SelectorManager(Dispatchers.IO)
    val socket = aSocket(selectorManager).tcp().connect("127.0.0.1", 9090)
    println("Connected to server.")
    val player = Player(socket)
    runCatching {
        while (true) {
            val query = player.receive()
            println(query)
            when (query) {
                is UsernameRole -> {
                    logger.info("My role is ${query.role}.")
                    role = query.role
                    player.send(UsernameWrapper(get("Username")))
                }
                is WhoIsJack -> {
                    logger.info("Jack is ${query.character}.")
                    Jack = query.character
                }
                is GameTurn -> {
                    val character = getListElement(query.remainingCards)
                    val move = getPosition("Move")
                    val action: CharacterAction = when (character) {
                        Character.AlfredElyBeach -> AlfredElyBeachAction(getPosition("Metro"))
                        Character.CloudRider -> CloudRiderAction(getPosition("Building"))
                        Character.LewisHowardLatimer -> HowardLatimerAction(getPosition("GasLight"))
                        Character.MrsEmmaGrant -> EmmaGrantAction(getPosition("Park"))
                        Character.JamesHCallahan -> JamesHCallahanAction(
                            get("Investigation tile id (1/2)").toInt(),
                            getPosition("Target 1") to getPosition("Target 2")
                        )
                        Character.MonkEastman -> MonkEastmanAction(getListElement(Character.values().toList()))
                        Character.FrancisJTumblety -> FrancisJTumbletyAction(
                            if (getConfirm("Swap"))
                                getListElement(Character.values().toList()) to getListElement(Character.values().toList())
                            else null
                        )
                        Character.EdwardSmith -> EdwardSmithAction(getPosition("Steamer from"), getPosition("To port space"))
                    }
                    val order = getListElement(PlayerEvent.EventOrder.values().toList())
                    val informantPosition: Position? =
                        if (getConfirm("Move informant")) {
                            getPosition("Informant")
                        } else null
                    player.send(
                        PlayerEvent(
                            selectedCard = character,
                            move = move,
                            action = action,
                            order = order,
                            informantPosition = informantPosition
                        )
                    )
                }
                is MrJackVisibility -> {
                    logger.info("Jack is${if (!query.isVisible) " not" else ""} visible.")
                }
                is Intrusion -> {
                    logger.info("${query.innocent} is innocent.")
                    innocents += query.innocent
                }
                is Winner -> {
                    if (query.role == role) {
                        println("Victory :)")
                    } else {
                        println("Defeat :(")
                    }
                    throw GameFinishedException()
                }
                else -> {
                    logger.warn("Unknown received query.")
                }
            }
            if (role == Role.Sherlock && getConfirm("Condemn")) {
                player.send(Condemn(getListElement(Character.values().toList())))
            }
        }
    }.onFailure {
        logger.error(it)
        println("Server disconnected.")
    }
}