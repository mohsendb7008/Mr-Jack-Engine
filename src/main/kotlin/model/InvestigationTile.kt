package model

import kotlinx.serialization.Serializable
import serializers.InvestigationTileSerializer
import toPair

@Serializable(with = InvestigationTileSerializer::class)
class InvestigationTile private constructor() {

    companion object {
        val investigationTile1 = InvestigationTile()
        val investigationTile2 = InvestigationTile()

        fun withId(id: Int) =
            when (id) {
                1 -> investigationTile1
                2 -> investigationTile2
                else -> throw IllegalArgumentException("ID of Investigation Tile should be 1 or 2.")
            }
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
