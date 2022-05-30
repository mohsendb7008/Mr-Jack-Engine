package qa

import model.Character
import model.Position
import qa.action.CharacterAction
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import serializers.json

@Serializable
data class PlayerEvent(
    val selectedCard: Character,
    val move: Position,
    val action: CharacterAction,
    val order: EventOrder,
    val informantPosition: Position?
) : QA() {
    override val code = 4
    override val description = "Here's my turn."

    enum class EventOrder {
        ActionFirst, MoveFirst
    }
}

fun PlayerEvent.Companion.fromJson(input: String) = json.decodeFromString<PlayerEvent>(input)

fun PlayerEvent.toJson() = json.encodeToString(this)
