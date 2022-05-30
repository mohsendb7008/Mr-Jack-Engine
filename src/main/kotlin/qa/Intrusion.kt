package qa

import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import model.Character
import serializers.json

@Suppress("MemberVisibilityCanBePrivate")
@Serializable
data class Intrusion(val innocent: Character): QA() {
    override val code = 5
    override val description = "The innocent character is $innocent"
}

fun Intrusion.Companion.fromJson(input: String) = json.decodeFromString<Intrusion>(input)

fun Intrusion.toJson() = json.encodeToString(this)
