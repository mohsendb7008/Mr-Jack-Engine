package qa

import model.Role
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import serializers.json

@Serializable
data class Winner(val role: Role): QA() {
    override val code = 8
    override val description = "$role won."
}

fun Winner.Companion.fromJson(input: String) = json.decodeFromString<Winner>(input)

fun Winner.toJson() = json.encodeToString(this)
