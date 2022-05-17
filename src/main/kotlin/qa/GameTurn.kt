package qa

import kotlinx.serialization.Serializable
import model.Cell
import model.Character
import model.VisibilityStatus

@Serializable
class GameTurn(
    val round: Int,
    val turn: Int,
    val map: List<Cell>,
    val visibilityStatus: VisibilityStatus,
    val remainingCards: List<Character>
) : QA() {
    override val code = 3
    override val description = "Play your turn."
}
