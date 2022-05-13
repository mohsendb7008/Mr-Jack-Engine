@file:OptIn(ExperimentalSerializationApi::class)

package serializers

import exception.DeserializationNotSupportedException
import kotlinx.serialization.*
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import model.*

@Serializable
@SerialName("StreetSpace")
private class StreetSpaceSurrogate(
    val position: Position,
    @Transient val adjacentPositions: List<Position> = emptyList(),
    var tile: Tile? = null,
    @EncodeDefault(mode = EncodeDefault.Mode.NEVER) val hasFixedTile: Boolean = false,
    val character: Character? = null,
    val investigationTile: InvestigationTile? = null,
    val informant: Informant? = null
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
            value.investigationTile,
            value.informant
        )
        encoder.encodeSerializableValue(StreetSpaceSurrogate.serializer(), surrogate)
    }

    override fun deserialize(decoder: Decoder) = throw DeserializationNotSupportedException("StreetSpace")
}

fun StreetSpace.toJson() = json.encodeToString(this)
