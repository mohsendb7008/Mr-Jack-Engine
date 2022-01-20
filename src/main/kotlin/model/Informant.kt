package model

import removeRandom

object Informant {

    var cell: Cell = LibertyIsland
        private set

    var mute: Boolean = false

    private val innocents: MutableList<Character> = Character.values().toMutableList().also { it.shuffle() }

    fun move(cell: Cell) {
        this.cell = cell
    }

    fun removeJack() = innocents.remove(Game.Jack)

    fun leakInnocent() : Character = innocents.removeRandom() // TODO Add validations (mute)

}