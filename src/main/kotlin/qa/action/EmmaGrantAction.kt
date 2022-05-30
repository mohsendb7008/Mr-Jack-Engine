package qa.action

import kotlinx.serialization.SerialName
import model.Position
import kotlinx.serialization.Serializable

@Serializable
@SerialName("EmmaGrantAction")
data class EmmaGrantAction(val parkPlace: Position): CharacterAction()
