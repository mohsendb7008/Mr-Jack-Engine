package qa

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import model.Character
import serializers.json

@Suppress("MemberVisibilityCanBePrivate")
@Serializable
@SerialName("Intrusion")
data class Intrusion(val innocent: Character): QA() {
    override val description = "The innocent character is $innocent"
}

fun Intrusion.Companion.fromJson(input: String) = json.decodeFromString<Intrusion>(input)

fun Intrusion.toJson() = json.encodeToString(this)
