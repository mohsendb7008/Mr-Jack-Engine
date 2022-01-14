package model

import pos

enum class Tile(val cells: MutableList<StreetSpace>) { // TODO: What about a new Tile?
    BuildingSite(mutableListOf(
        StreetSpace.map[4 pos 9]!!,
        StreetSpace.map[4 pos 11]!!,
        StreetSpace.map[10 pos 5]!!,
        StreetSpace.map[10 pos 11]!!,
        StreetSpace.map[11 pos 6]!!,
        StreetSpace.map[11 pos 10]!!
    )),
    MetroEntrance(mutableListOf(
        StreetSpace.map[2 pos 9]!!,
        StreetSpace.map[11 pos 4]!!,
        StreetSpace.map[12 pos 13]!!
    )),
    GasLamp(mutableListOf(
        StreetSpace.map[3 pos 10]!!,
        StreetSpace.map[13 pos 12]!!
    )),
    Park(ArrayList())
}