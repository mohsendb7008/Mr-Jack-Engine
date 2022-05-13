package qa

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import model.Board
import model.Cell
import model.Character
import model.VisibilityStatus
import serializers.json

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

fun main() {
    val instance =
        GameTurn(2, 1, Board.cells.values.toList(), VisibilityStatus.Day, Character.values().toList().take(4))
    val string = json.encodeToString(instance)
    println(string)
}
