package qa.action

import kotlinx.serialization.SerialName
import model.Position
import kotlinx.serialization.Serializable

@Serializable
@SerialName("JamesHCallahanAction")
data class JamesHCallahanAction(val id: Int, val position: Position): CharacterAction() {
    init {
        require(id in 1..2)
    }
}
