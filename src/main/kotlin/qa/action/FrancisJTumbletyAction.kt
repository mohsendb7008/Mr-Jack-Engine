package qa.action

import kotlinx.serialization.SerialName
import model.Character
import kotlinx.serialization.Serializable

@Serializable
@SerialName("FrancisJTumbletyAction")
data class FrancisJTumbletyAction(val characters: Pair<Character, Character>?): CharacterAction()
