package qa

import model.Character
import model.Position
import qa.action.CharacterAction

enum class EventOrder {
    ActionFirst, MoveFirst
}

class PlayerEvent(
    val selectedCard: Character,
    val move: Position,
    val action: CharacterAction,
    val order: EventOrder,
    val informantPosition: Position?
) : QA() {
    override val code = 4
    override val description = "Here's my turn."
}
