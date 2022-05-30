package qa

import model.Character
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import serializers.json

@Serializable
data class Condemn(val character: Character): QA() {
    override val code = 7
    override val description = "Sherlock believes that $character is Mr Jack."
}

fun Condemn.Companion.fromJson(input: String) = json.decodeFromString<Condemn>(input)

fun Condemn.toJson() = json.encodeToString(this)
