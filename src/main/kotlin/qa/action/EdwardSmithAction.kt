package qa.action

import kotlinx.serialization.SerialName
import model.Position
import kotlinx.serialization.Serializable

@Serializable
@SerialName("EdwardSmithAction")
data class EdwardSmithAction(val from: Position, val to: Position): CharacterAction()
