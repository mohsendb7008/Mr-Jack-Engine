package qa.action

import kotlinx.serialization.Serializable
import kotlinx.serialization.modules.SerializersModuleBuilder
import kotlinx.serialization.modules.polymorphic

@Serializable
sealed class CharacterAction

val characterActionSerializerModuleBuilder: SerializersModuleBuilder.() -> Unit = {
    polymorphic(CharacterAction::class) {
        subclass(AlfredElyBeachAction::class, AlfredElyBeachAction.serializer())
        subclass(CloudRiderAction::class, CloudRiderAction.serializer())
        subclass(EdwardSmithAction::class, EdwardSmithAction.serializer())
        subclass(EmmaGrantAction::class, EmmaGrantAction.serializer())
        subclass(FrancisJTumbletyAction::class, FrancisJTumbletyAction.serializer())
        subclass(HowardLatimerAction::class, HowardLatimerAction.serializer())
        subclass(JamesHCallahanAction::class, JamesHCallahanAction.serializer())
        subclass(MonkEastmanAction::class, MonkEastmanAction.serializer())
    }
}
