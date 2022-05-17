package qa.action

import model.Position
import kotlinx.serialization.Serializable

@Serializable
class HowardLatimerAction(val gasLightPlace: Position): CharacterAction
