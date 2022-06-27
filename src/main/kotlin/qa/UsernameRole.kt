package qa

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import model.Role
import serializers.json

@Serializable
@SerialName("UsernameRole")
data class UsernameRole(
    val role: Role
) : QA() {
    override val description: String = "Your role is $role. What is your username?"
}

fun UsernameRole.Companion.fromJson(input: String) = json.decodeFromString<UsernameRole>(input)

fun UsernameRole.toJson() = json.encodeToString(this)
