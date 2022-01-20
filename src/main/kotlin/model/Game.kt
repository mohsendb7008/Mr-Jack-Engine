package model

object Game {

    var round: Int = 1
    var turn: Int = 1 // [1, 4] TODO Add Observable
    lateinit var Jack: Character
    lateinit var cards: List<Character>

    val isJackVisible: Boolean get() = Jack.isVisible
    val visibleCharacters: List<Character> get() = Character.values().filter { it.isVisible }
    val invisibleCharacters: List<Character> get() = Character.values().filterNot { it.isVisible }
    val suspectCharacters: List<Character> get() = Character.values().filter { it.isSuspect }
    val innocentCharacters: List<Character> get() = Character.values().filterNot { it.isSuspect }

    fun nextCycle() {
        if (turn == 4) {
            round++
            turn = 1
        }
        else {
            turn++
        }
    }

}