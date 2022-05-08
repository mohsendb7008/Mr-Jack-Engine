package qa
import model.Character

class WhoIsJack(val character: Character): QA() {
    override val code = 2
    override val description = "Mr jack is: ${character.name}."
}
