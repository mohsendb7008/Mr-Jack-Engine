package model

import kotlinx.serialization.Serializable
import serializers.CharacterSerializer

@Serializable(with = CharacterSerializer::class)
enum class Character(isVisible: Boolean) {

    AlfredElyBeach(true) {

        private fun constructMetroEntrance(cell: StreetSpace) {
            // TODO Add validations
            cell.tile = Tile.MetroEntrance
        }

        override fun performAction(arg1: Any, arg2: Any?) {
            constructMetroEntrance(arg1 as StreetSpace)
        }

    },

    CloudRider(true) {

        override fun moveTo(cell: Cell) = TODO()

        private fun constructBuildingSite(cell: StreetSpace) {
            // TODO Add validations
            cell.tile = Tile.BuildingSite
        }

        override fun performAction(arg1: Any, arg2: Any?) {
            constructBuildingSite(arg1 as StreetSpace)
        }

    },

    LewisHowardLatimer(true) {

        private fun installGasLamp(cell: StreetSpace) {
            // TODO Add validations
            cell.tile = Tile.GasLamp
        }

        override fun performAction(arg1: Any, arg2: Any?) {
            installGasLamp(arg1 as StreetSpace)
        }

    },

    MrsEmmaGrant(true) {

        private fun createPark(cell: StreetSpace) {
            // TODO Add validations
            cell.tile = Tile.Park
        }

        override fun performAction(arg1: Any, arg2: Any?) {
            createPark(arg1 as StreetSpace)
        }

    },

    JamesHCallahan(true) {

        private fun moveInvestigationTile(tile: InvestigationTile, cells: Pair<StreetSpace, StreetSpace>) {
            // TODO Add validations
            cells.first.investigationTile = tile
            cells.second.investigationTile = tile
        }

        @Suppress("UNCHECKED_CAST")
        override fun performAction(arg1: Any, arg2: Any?) {
            moveInvestigationTile(arg1 as InvestigationTile, arg2 as Pair<StreetSpace, StreetSpace>)
        }

    },

    MonkEastman(false) {

        private fun moveAnotherCharacter(character: Character, cell: Cell) {
            // TODO Add validations
            character.moveTo(cell)
        }

        override fun performAction(arg1: Any, arg2: Any?) {
            moveAnotherCharacter(arg1 as Character, arg2 as Cell)
        }

    },

    FrancisJTumblety(false) {

        private fun hypnotize(adjacent: Character, target: Character) {
            // TODO Add validations
            adjacent.moveTo(target.cell.also { target.moveTo(adjacent.cell) })
        }

        override fun performAction(arg1: Any, arg2: Any?) {
            hypnotize(arg1 as Character, arg2 as Character)
        }

    },

    EdwardSmith(true) {

        private fun moveSteamer(from: PortSpace, to: PortSpace) {
            // TODO Add validations
            from.hasSteamer = false
            to.hasSteamer = true
        }

        override fun performAction(arg1: Any, arg2: Any?) {
            moveSteamer(arg1 as PortSpace, arg2 as PortSpace)
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

    abstract fun performAction(arg1: Any, arg2: Any? = null)

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
