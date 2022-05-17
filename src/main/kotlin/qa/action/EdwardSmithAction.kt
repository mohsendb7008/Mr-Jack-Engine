package qa.action

import model.Position
import kotlinx.serialization.Serializable

@Serializable
class EdwardSmithAction(val from: Position, val to: Position): CharacterAction
