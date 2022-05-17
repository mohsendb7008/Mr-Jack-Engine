package qa.action

import model.Position
import kotlinx.serialization.Serializable

@Serializable
class CloudRiderAction(val buildingPlace: Position): CharacterAction
