package qa
import model.Character
import kotlinx.serialization.Serializable

@Serializable
class WhoIsJack(val character: Character): QA() {
    override val code = 2
    override val description = "Mr jack is: ${character.name}."
}
