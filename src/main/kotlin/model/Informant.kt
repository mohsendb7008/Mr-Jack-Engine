package model

import kotlin.random.Random

object Informant {
    var cell: Cell = LibertyIsland
        private set

    var mute: Boolean = true

    private val innocents: MutableList<Character> = Character.values().toMutableList().also { it.shuffle() }

    fun move(cell: Cell) {
        this.cell = cell
    }

    fun removeJack(jack: Character): Boolean = innocents.remove(jack)

    fun leakInnocent() : Character = innocents.removeAt(Random(innocents.size).nextInt())
}