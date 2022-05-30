package qa.action

import kotlinx.serialization.SerialName
import model.Position
import kotlinx.serialization.Serializable

@Serializable
@SerialName("AlfredElyBeachAction")
data class AlfredElyBeachAction(val metroPlace: Position): CharacterAction()
