package qa

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import model.Role
import serializers.json

@Serializable
@SerialName("Winner")
data class Winner(val role: Role): QA() {
    override val description = "$role won."
}

fun Winner.Companion.fromJson(input: String) = json.decodeFromString<Winner>(input)

fun Winner.toJson() = json.encodeToString(this)
