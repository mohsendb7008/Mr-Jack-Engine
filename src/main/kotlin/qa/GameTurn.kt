package qa

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import model.*

@Serializable
class GameTurn(
    val round: Int,
    val turn: Int,
    val map: List<Cell>,
    val visibilityStatus: VisibilityStatus,
    val remainingCards: List<Character>,
    val informant: Informant = Informant
) : QA() {
    override val code = 3
    override val description = ""
}

fun main() {
    val instance = GameTurn(2, 1, StreetSpace.cells.values.toList(), VisibilityStatus.Day, Character.values().toList().take(4))
    val string = json.encodeToString(instance)
    println(string)
//    Json.decodeFromString<UsernameRole>(string)
}
