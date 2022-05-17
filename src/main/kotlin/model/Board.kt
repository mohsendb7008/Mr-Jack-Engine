package model

object Board {

    val cells = StreetSpace.cells + QuaysideSpace.cells + PortSpace.cells + listOf(
        LibertyIsland, LandExit
    ).associateBy { it.position }

    val tiles: Map<Position, Tile>
        get() = (StreetSpace.cells.values.filter { it.tile != null }).associate { it.position to it.tile!! }

}
