package qa

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import model.Cell
import model.Character
import model.VisibilityStatus
import serializers.json

@Serializable
@SerialName("GameTurn")
class GameTurn(
    val round: Int,
    val turn: Int,
    val map: List<Cell>,
    val visibilityStatus: VisibilityStatus,
    val remainingCards: List<Character>
) : QA() {
    override val description = "Play your turn."
    init {
        require(round in 1..8)
        require(turn in 1..4)
    }
}

fun GameTurn.Companion.fromJson(input: String) = json.decodeFromString<GameTurn>(input)

fun GameTurn.toJson() = json.encodeToString(this)
