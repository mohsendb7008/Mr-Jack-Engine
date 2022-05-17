package qa

import kotlinx.serialization.Serializable
import model.Role

@Serializable
class UsernameRole(
    val role: Role
) : QA() {
    override val code: Int = 1
    override val description: String = "Your role is $role. What is your username?"
}

