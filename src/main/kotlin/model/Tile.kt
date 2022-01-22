package model

import kotlinx.serialization.Serializable
import serializers.TileSerializer

@Serializable(with = TileSerializer::class)
enum class Tile {

    BuildingSite, MetroEntrance, GasLamp, Park;

    val streetSpaces: List<StreetSpace>
        get() = StreetSpace.cells.values.filter { it.tile == this }

    companion object
}