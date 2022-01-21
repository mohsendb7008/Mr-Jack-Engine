package serialization

import kotlinx.serialization.Serializable
import model.Tile

@Serializable
data class SerializableTile(val type: Tile)