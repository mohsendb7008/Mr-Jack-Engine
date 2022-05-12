package model

import kotlinx.serialization.Serializable
import removeRandom

// TODO Write serializer and not Nothing
@Serializable
object Informant {

    var mute: Boolean = false

    private val innocents: MutableList<Character> = Character.values().toMutableList().also { it.shuffle() }

    fun removeJack() = innocents.remove(Game.Jack)

    fun leakInnocent() : Character = innocents.removeRandom() // TODO Add validations (mute)

    private val cell: Cell
        get() = Board.cells.values.first {
            it.informant == this
        }

    fun moveTo(cell: Cell) {
        // TODO validate
        this.cell.informant = null
        cell.informant = this
    }

}
