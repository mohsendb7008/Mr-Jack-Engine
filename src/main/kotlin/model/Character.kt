package model

import pos

enum class Character(cell: Cell, isVisible: Boolean, isSuspect: Boolean = true){
    AlfredElyBeach(StreetSpace.map[5 pos 10]!!, true) {
        fun constructMetroEntrance(cell: StreetSpace) {
            cell.tile = Tile.MetroEntrance
            Tile.MetroEntrance.cells.add(cell)
        }
    },

    CloudRider(StreetSpace.map[9 pos 8]!!, true) {
        override fun moveTo(cell: Cell) = TODO()

        fun constructBuildingSite(cell: StreetSpace) {
            cell.tile = Tile.BuildingSite
            Tile.BuildingSite.cells.add(cell)
        }
    },

    LewisHowardLatimer(StreetSpace.map[5 pos 8]!!, true) {
        fun installGasLamp(cell: StreetSpace) {
            cell.tile = Tile.GasLamp
            Tile.GasLamp.cells.add(cell)
        }
    },

    MrsEmmaGrant(StreetSpace.map[10 pos 7]!!, true) {
        fun createPark(cell: StreetSpace) {
            cell.tile?.let {
                it.cells.remove(cell)
                cell.tile = Tile.Park
                Tile.Park.cells.add(cell)
            }
        }
    },

    JamesHCallahan(StreetSpace.map[6 pos 9]!!, true) {
        fun moveInvestigationTile(tile: InvestigationTile, cells: Pair<StreetSpace, StreetSpace>) {
            tile.blockedCells = cells
        }
    },

    MonkEastman(StreetSpace.map[8 pos 5]!!, false) {
        fun moveAnotherCharacter(character: Character, cell: Cell){
            character.moveTo(cell)
        }
    },

    FrancisJTumblety(StreetSpace.map[8 pos 11]!!, false) {
        fun hypnotize(adjacent: Character, target: Character){
            adjacent.moveTo(target.cell.also { target.moveTo(adjacent.cell) })
        }
    },

    EdwardSmith(StreetSpace.map[10 pos 9]!!, true) {
        fun moveSteamer(from: PortSpace, to: PortSpace){
            from.hasSteamer = false
            to.hasSteamer = true
        }
    };

    var cell: Cell = cell
        private set

    var isVisible: Boolean = isVisible
        private set

    var isSuspect: Boolean = isSuspect
        private set

    open fun moveTo(cell: Cell) {
        this.cell = cell
    }

    fun toggleVisibility(){
        this.isVisible = !this.isVisible
    }

    fun exonerate(){
        this.isSuspect = false
    }
}