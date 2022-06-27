package qa
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import model.Character
import serializers.json

@Serializable
@SerialName("WhoIsJack")
data class WhoIsJack(val character: Character): QA() {
    override val description = "Mr jack is: ${character.name}."
}

fun WhoIsJack.Companion.fromJson(input: String) = json.decodeFromString<WhoIsJack>(input)

fun WhoIsJack.toJson() = json.encodeToString(this)
