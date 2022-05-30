package qa.action

import kotlinx.serialization.SerialName
import model.Position
import kotlinx.serialization.Serializable

@Serializable
@SerialName("HowardLatimerAction")
data class HowardLatimerAction(val gasLightPlace: Position): CharacterAction()
