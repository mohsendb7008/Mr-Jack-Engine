package serializers

import exception.DeserializationNotSupportedException
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import model.Informant

@Serializable
@SerialName("Informant")
private class InformantSurrogate(val mute: Boolean)

object InformantSerializer : KSerializer<Informant> {
    override val descriptor = InformantSurrogate.serializer().descriptor
    override fun serialize(encoder: Encoder, value: Informant) {
        val surrogate = InformantSurrogate(Informant.mute)
        encoder.encodeSerializableValue(InformantSurrogate.serializer(), surrogate)
    }

    override fun deserialize(decoder: Decoder) = throw DeserializationNotSupportedException("Informant")
}
