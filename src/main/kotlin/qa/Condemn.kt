package qa

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import model.Character
import serializers.json

@Serializable
@SerialName("Condemn")
data class Condemn(val character: Character): QA() {
    override val description = "Sherlock believes that $character is Mr Jack."
}

fun Condemn.Companion.fromJson(input: String) = json.decodeFromString<Condemn>(input)

fun Condemn.toJson() = json.encodeToString(this)
