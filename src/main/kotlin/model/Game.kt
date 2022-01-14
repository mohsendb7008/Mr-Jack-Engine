package model

object Game {
    private var round: Int = 1
    private var turn: Int = 1
    private lateinit var Jack: Character
    private var jackVisibility: Boolean = true
    private var cards: MutableList<Character> = CardDealer.deal(turn)
    private var visibleCharacters: MutableList<Character> = mutableListOf(Character.AlfredElyBeach, Character.CloudRider,
        Character.EdwardSmith, Character.JamesHCallahan, Character.LewisHowardLatimer, Character.MrsEmmaGrant)
    private var invisibleCharacters: MutableList<Character>
            = mutableListOf<Character>(Character.FrancisJTumblety, Character.MonkEastman)
    private var innocentCharacters: MutableList<Character> = ArrayList()
}