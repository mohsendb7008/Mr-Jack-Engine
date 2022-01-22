package serializers

import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.Json
import model.Character

@Serializable
@SerialName("Character")
private class CharacterSurrogate(val type: String, val isVisible: Boolean, val isSuspect: Boolean) {
    init {
        require(Character.values().any { it.name == type })
    }
}

object CharacterSerializer: KSerializer<Character> {
    override val descriptor = CharacterSurrogate.serializer().descriptor

    override fun deserialize(decoder: Decoder): Character {
        val surrogate = decoder.decodeSerializableValue(CharacterSurrogate.serializer())
        return Character.valueOf(surrogate.type).also {
            if (!surrogate.isSuspect) {
                it.exonerate()
            }
            if (it.isVisible != surrogate.isVisible) {
                it.toggleVisibility()
            }
        }
    }

    override fun serialize(encoder: Encoder, value: Character) {
        val surrogate = CharacterSurrogate(value.name, value.isVisible, value.isSuspect)
        encoder.encodeSerializableValue(CharacterSurrogate.serializer(), surrogate)
    }
}

fun Character.Companion.deserialize(input: String) = Json.decodeFromString<Character>(input)