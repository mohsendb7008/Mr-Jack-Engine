package model

import kotlinx.serialization.Serializable

@Serializable
class InvestigationTile private constructor() {

    companion object {

        val investigationTile1 = InvestigationTile()
        val investigationTile2 = InvestigationTile()

    }

    val blockedCells: Pair<StreetSpace, StreetSpace>
        get() = StreetSpace.cells.values.first { it.investigationTile == this } to StreetSpace.cells.values.last { it.investigationTile == this }

}