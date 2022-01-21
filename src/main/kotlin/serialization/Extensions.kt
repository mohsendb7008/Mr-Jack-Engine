package serialization

import model.Tile

fun Tile.serialize() = SerializableTile(this)