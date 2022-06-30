package qa.action

import kotlinx.serialization.SerialName
import model.Position
import kotlinx.serialization.Serializable

@Serializable
@SerialName("JamesHCallahanAction")
data class JamesHCallahanAction(val id: Int, val positions: Pair<Position, Position>): CharacterAction() {
    init {
        require(id in 1..2)
    }
}
