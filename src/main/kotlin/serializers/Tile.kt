package serializers

import kotlinx.serialization.*
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import model.Tile

@Serializable
@SerialName("Tile")
private class TileSurrogate(val type: String) {
    init {
        require(Tile.values().any { it.name === type })
    }
}

object TileSerializer : KSerializer<Tile> {
    override val descriptor: SerialDescriptor = TileSurrogate.serializer().descriptor

    override fun serialize(encoder: Encoder, value: Tile) {
        val surrogate = TileSurrogate(value.name)
        encoder.encodeSerializableValue(TileSurrogate.serializer(), surrogate)
    }

    override fun deserialize(decoder: Decoder): Tile {
        val surrogate = decoder.decodeSerializableValue(TileSurrogate.serializer())
        return Tile.valueOf(surrogate.type)
    }

}

fun Tile.Companion.fromJson(input: String) = json.decodeFromString<Tile>(input)

fun Tile.toJson() = json.encodeToString(this)
