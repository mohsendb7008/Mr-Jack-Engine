package serializers

import exception.DeserializationNotSupportedException
import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import model.InvestigationTile

class InvestigationTileSerializer(): KSerializer<InvestigationTile> {
    override val descriptor = Int.serializer().descriptor

    override fun serialize(encoder: Encoder, value: InvestigationTile) {
        encoder.encodeInt(if (value === InvestigationTile.investigationTile1) 1 else 2)
    }

    override fun deserialize(decoder: Decoder) = throw DeserializationNotSupportedException("InvestigationTile")
}
