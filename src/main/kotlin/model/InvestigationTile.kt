package model

import kotlinx.serialization.Serializable
import serializers.InvestigationTileSerializer
import toPair

@Serializable(with = InvestigationTileSerializer::class)
class InvestigationTile private constructor() {

    companion object {
        val investigationTile1 = InvestigationTile()
        val investigationTile2 = InvestigationTile()
    }

    val blockedCells: Pair<StreetSpace, StreetSpace>
        get() = StreetSpace.cells.values.filter { it.investigationTile == this }.toPair()

    fun moveTo(streetSpaces: Pair<StreetSpace, StreetSpace>) {
        blockedCells.toList().forEach {
            it.investigationTile = null
        }
        streetSpaces.toList().forEach {
            it.investigationTile = this
        }
    }
}
