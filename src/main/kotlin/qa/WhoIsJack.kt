package qa
import model.Character
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import serializers.json

@Serializable
data class WhoIsJack(val character: Character): QA() {
    override val code = 2
    override val description = "Mr jack is: ${character.name}."
}

fun WhoIsJack.Companion.fromJson(input: String) = json.decodeFromString<WhoIsJack>(input)

fun WhoIsJack.toJson() = json.encodeToString(this)
