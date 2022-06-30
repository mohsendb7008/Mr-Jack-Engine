package model

import kotlinx.serialization.Serializable
import serializers.CharacterSerializer

@Serializable(with = CharacterSerializer::class)
enum class Character(isVisible: Boolean) {

    AlfredElyBeach(true) {

        @Suppress("unused")
        fun constructMetroEntranceAction(cell: StreetSpace) {
            // TODO Add validations
            cell.tile = Tile.MetroEntrance
        }
    },

    CloudRider(true) {

        override fun moveTo(cell: Cell) = TODO()

        @Suppress("unused")
        fun constructBuildingSiteAction(cell: StreetSpace) {
            // TODO Add validations
            cell.tile = Tile.BuildingSite
        }
    },

    LewisHowardLatimer(true) {

        @Suppress("unused")
        fun installGasLampAction(cell: StreetSpace) {
            // TODO Add validations
            cell.tile = Tile.GasLamp
        }
    },

    MrsEmmaGrant(true) {

        @Suppress("unused")
        fun createParkAction(cell: StreetSpace) {
            // TODO Add validations
            cell.tile = Tile.Park
        }
    },

    JamesHCallahan(true) {

        @Suppress("unused")
        fun moveInvestigationTileAction(tile: InvestigationTile, cells: Pair<StreetSpace, StreetSpace>) {
            // TODO Add validations
            cells.first.investigationTile = tile
            cells.second.investigationTile = tile
        }
    },

    MonkEastman(false) {

        @Suppress("unused")
        fun moveAnotherCharacterAction(character: Character, cell: Cell) {
            // TODO Add validations
            character.moveTo(cell)
        }

    },

    FrancisJTumblety(false) {

        @Suppress("unused")
        fun hypnotizeAction(adjacent: Character, target: Character) {
            // TODO Add validations
            adjacent.moveTo(target.cell.also { target.moveTo(adjacent.cell) })
        }
    },

    EdwardSmith(true) {

        @Suppress("unused")
        fun moveSteamerAction(from: PortSpace, to: PortSpace) {
            // TODO Add validations
            from.hasSteamer = false
            to.hasSteamer = true
        }
    };

    val cell: Cell
        get() = Board.cells.values.first { it.character == this }

    var isVisible: Boolean = isVisible
        private set

    var isSuspect: Boolean = true
        private set

    open fun moveTo(cell: Cell) {
        // TODO validate
        this.cell.character = null
        cell.character = this
    }

    fun performAction(arg1: Any, arg2: Any? = null) {
        val actionMethod = this::class.java.declaredMethods.find { it.name.endsWith("Action") }
        val paramsArray = arrayOf(arg1, arg2)
        actionMethod?.invoke(this, *paramsArray.filterNotNull().toTypedArray())
    }

    fun toggleVisibility() {
        // TODO validate
        this.isVisible = !this.isVisible
    }

    fun exonerate() {
        // TODO validate
        this.isSuspect = false
    }

    companion object
}
