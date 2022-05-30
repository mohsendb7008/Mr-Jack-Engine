package qa.action

import kotlinx.serialization.SerialName
import model.Character
import kotlinx.serialization.Serializable

@Serializable
@SerialName("MonkEastmanAction")
data class MonkEastmanAction(val character: Character): CharacterAction()
