package serializers

import kotlinx.serialization.*
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import model.Character

@Serializable
@SerialName("Character")
private class CharacterSurrogate(
    val type: String, val isSuspect: Boolean = Character.values().first { it.name == type }.isSuspect
) {
    init {
        require(type in Character.values().map { it.name })
    }
}

object CharacterSerializer : KSerializer<Character> {
    override val descriptor = CharacterSurrogate.serializer().descriptor

    override fun deserialize(decoder: Decoder): Character {
        val surrogate = decoder.decodeSerializableValue(CharacterSurrogate.serializer())
        return Character.valueOf(surrogate.type)
    }

    override fun serialize(encoder: Encoder, value: Character) {
        val surrogate = CharacterSurrogate(value.name, value.isSuspect)
        encoder.encodeSerializableValue(CharacterSurrogate.serializer(), surrogate)
    }
}

fun Character.Companion.fromJson(input: String) = json.decodeFromString<Character>(input)

fun Character.toJson() = json.encodeToString(this)
