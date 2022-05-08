package qa

import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import model.Role

@Serializable
class UsernameRole(
    val role: Role
) : QA() {

    override val code: Int = 1

    override val description: String = "Your role is $role. What is your username?"

}

val json = Json { encodeDefaults = true }

// Driver code to test:
fun main() {
    val instance = UsernameRole(Role.Jack)
    val string = json.encodeToString(instance)
    println(string)
    Json.decodeFromString<UsernameRole>(string)
}
