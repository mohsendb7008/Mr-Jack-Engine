package qa.action

import model.Character
import kotlinx.serialization.Serializable

@Serializable
class FrancisJTumbletyAction(val characters: Pair<Character, Character>?): CharacterAction
