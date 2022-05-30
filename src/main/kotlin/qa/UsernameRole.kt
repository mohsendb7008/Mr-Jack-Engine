package qa

import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import model.Role
import serializers.json

@Serializable
data class UsernameRole(
    val role: Role
) : QA() {
    override val code: Int = 1
    override val description: String = "Your role is $role. What is your username?"
}

fun UsernameRole.Companion.fromJson(input: String) = json.decodeFromString<UsernameRole>(input)

fun UsernameRole.toJson() = json.encodeToString(this)
