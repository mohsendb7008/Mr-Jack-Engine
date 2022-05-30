package qa.action

import kotlinx.serialization.SerialName
import model.Position
import kotlinx.serialization.Serializable

@Serializable
@SerialName("CloudRiderAction")
data class CloudRiderAction(val buildingPlace: Position): CharacterAction()
