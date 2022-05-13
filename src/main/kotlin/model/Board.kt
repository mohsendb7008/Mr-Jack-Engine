package model

object Board {

    val cells = StreetSpace.cells + QuaysideSpace.cells + PortSpace.cells + listOf(
        LibertyIsland, LandExit
    ).associateBy { it.position }

    val tiles: Map<Position, Tile>
        get() = (Tile.BuildingSite.streetSpaces + Tile.MetroEntrance.streetSpaces + Tile.GasLamp.streetSpaces + Tile.Park.streetSpaces).associate { it.position to it.tile!! }

}
