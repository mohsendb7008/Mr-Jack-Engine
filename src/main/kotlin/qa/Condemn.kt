package qa

import model.Character
import kotlinx.serialization.Serializable

@Serializable
class Condemn(val character: Character): QA() {
    override val code = 7
    override val description = "Sherlock believes that $character is Mr Jack."
}
