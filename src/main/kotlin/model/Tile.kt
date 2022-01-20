package model

enum class Tile {

    BuildingSite, MetroEntrance, GasLamp, Park;

    val streetSpaces: List<StreetSpace>
        get() = StreetSpace.cells.values.filter { it.tile == this }

}