package qa.action

import model.Position
import kotlinx.serialization.Serializable

@Serializable
class JamesHCallahanAction(val id: Int, val position: Position): CharacterAction {
    init {
        require(id in 1..2)
    }
}
