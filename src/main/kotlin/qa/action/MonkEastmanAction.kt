package qa.action

import model.Character
import kotlinx.serialization.Serializable

@Serializable
class MonkEastmanAction(val character: Character): CharacterAction
