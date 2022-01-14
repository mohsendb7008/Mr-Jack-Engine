package model

object Board{
    val map = StreetSpace.map + QuaysideSpace.map + PortSpace.map + listOf(
        LibertyIsland,
        LandExit
    ).associateBy { it.position }
    val tiles =
        (Tile.BuildingSite.cells + Tile.MetroEntrance.cells + Tile.GasLamp.cells + Tile.Park.cells).associate { it.position to it.tile }
}