package serializers

import exception.DeserializationNotSupportedException
import kotlinx.serialization.*
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import model.PortSpace
import model.Position

@Serializable
@SerialName("PortSpace")
private class PortSpaceSurrogate(
    val position: Position, @Transient val adjacentPositions: List<Position> = emptyList(), val hasSteamer: Boolean
)

class PortSpaceSerializer : KSerializer<PortSpace> {
    override val descriptor = PortSpaceSurrogate.serializer().descriptor

    override fun serialize(encoder: Encoder, value: PortSpace) {
        val surrogate = PortSpaceSurrogate(
            value.position, value.adjacentPositions, value.hasSteamer
        )
        encoder.encodeSerializableValue(PortSpaceSurrogate.serializer(), surrogate)
    }

    override fun deserialize(decoder: Decoder) = throw DeserializationNotSupportedException("PortSpace")
}

fun PortSpace.toJson() = json.encodeToString(this)
