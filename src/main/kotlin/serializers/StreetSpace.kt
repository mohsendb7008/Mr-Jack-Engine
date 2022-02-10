package serializers

import kotlinx.serialization.*
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.Json
import model.*

@Serializable
@SerialName("StreetSpace")
private class StreetSpaceSurrogate(
    val position: Position,
    val adjacentPositions: List<Position>,
    var tile: Tile? = null,
    val hasFixedTile: Boolean = false,
    val character: Character? = null,
    val investigationTile: InvestigationTile? = null
)

class StreetSpaceSerializer : KSerializer<StreetSpace> {
    override val descriptor = StreetSpaceSurrogate.serializer().descriptor

    override fun serialize(encoder: Encoder, value: StreetSpace) {
        val surrogate = StreetSpaceSurrogate(
            value.position,
            value.adjacentPositions,
            value.tile,
            value.hasFixedTile,
            value.character,
            value.investigationTile
        )
        encoder.encodeSerializableValue(StreetSpaceSurrogate.serializer(), surrogate)
    }

    override fun deserialize(decoder: Decoder): StreetSpace {
        val surrogate = decoder.decodeSerializableValue(StreetSpaceSurrogate.serializer())
        return StreetSpace(
            surrogate.position,
            *surrogate.adjacentPositions.toTypedArray(),
            tile = surrogate.tile,
            hasFixedTile = surrogate.hasFixedTile,
            character = surrogate.character,
            investigationTile = surrogate.investigationTile
        )
    }
}

fun StreetSpace.Companion.deserialize(input: String) = Json.decodeFromString<StreetSpace>(input)

fun StreetSpace.serialize() = Json.encodeToString(this)
