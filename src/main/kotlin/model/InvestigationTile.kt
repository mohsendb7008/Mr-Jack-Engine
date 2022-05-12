package model

import kotlinx.serialization.Serializable

@Serializable
class InvestigationTile private constructor() {

    companion object {
        val investigationTile1 = InvestigationTile()
        val investigationTile2 = InvestigationTile()
    }

    val blockedCells: Pair<StreetSpace, StreetSpace>
        get() = StreetSpace.cells.values.filter { it.investigationTile == this }.let {
            val (first, second) = it
            first to second
        }

    fun moveTo(streetSpaces: Pair<StreetSpace, StreetSpace>) {
        blockedCells.toList().forEach {
            it.investigationTile = null
        }
        streetSpaces.toList().forEach {
            it.investigationTile = this
        }
    }
}
