package qa

import kotlinx.serialization.Serializable
import model.Character

@Suppress("MemberVisibilityCanBePrivate")
@Serializable
class Intrusion(val innocent: Character): QA() {
    override val code = 5
    override val description = "The innocent character is $innocent"
}
