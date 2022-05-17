package qa

import model.Role
import kotlinx.serialization.Serializable

@Serializable
class Winner(val role: Role): QA() {
    override val code = 8
    override val description = "$role won."
}
