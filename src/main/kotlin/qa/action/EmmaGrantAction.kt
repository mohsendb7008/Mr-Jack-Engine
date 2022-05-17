package qa.action

import model.Position
import kotlinx.serialization.Serializable

@Serializable
class EmmaGrantAction(val parkPlace: Position): CharacterAction
