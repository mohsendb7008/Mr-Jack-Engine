package model

import kotlinx.serialization.Serializable
import serializers.CharacterSerializer

@Serializable(with = CharacterSerializer::class)
enum class Character(isVisible: Boolean) {

    AlfredElyBeach(true) {

        fun constructMetroEntrance(cell: StreetSpace) {
            // TODO Add validations
            cell.tile = Tile.MetroEntrance
        }

    },

    CloudRider(true) {

        override fun moveTo(cell: Cell) = TODO()

        fun constructBuildingSite(cell: StreetSpace) {
            // TODO Add validations
            cell.tile = Tile.BuildingSite
        }

    },

    LewisHowardLatimer(true) {

        fun installGasLamp(cell: StreetSpace) {
            // TODO Add validations
            cell.tile = Tile.GasLamp
        }

    },

    MrsEmmaGrant(true) {

        fun createPark(cell: StreetSpace) {
            // TODO Add validations
            cell.tile = Tile.Park
        }

    },

    JamesHCallahan(true) {

        fun moveInvestigationTile(tile: InvestigationTile, cells: Pair<StreetSpace, StreetSpace>) {
            // TODO Add validations
            cells.first.investigationTile = tile
            cells.second.investigationTile = tile
        }

    },

    MonkEastman(false) {

        fun moveAnotherCharacter(character: Character, cell: Cell) {
            // TODO Add validations
            character.moveTo(cell)
        }

    },

    FrancisJTumblety(false) {

        fun hypnotize(adjacent: Character, target: Character) {
            // TODO Add validations
            adjacent.moveTo(target.cell.also { target.moveTo(adjacent.cell) })
        }

    },

    EdwardSmith(true) {

        fun moveSteamer(from: PortSpace, to: PortSpace) {
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
        cell.character = this
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