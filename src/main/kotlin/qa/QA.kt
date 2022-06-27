package qa

import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.modules.SerializersModuleBuilder
import kotlinx.serialization.modules.polymorphic
import serializers.json

@Serializable
sealed class QA {
    abstract val description: String
}

fun QA.Companion.fromJson(input: String) = json.decodeFromString<QA>(input)

fun QA.toJson() = json.encodeToString(this)

val qaSerializerModuleBuilder: SerializersModuleBuilder.() -> Unit = {
    polymorphic(QA::class) {
        subclass(Condemn::class, Condemn.serializer())
        subclass(GameTurn::class, GameTurn.serializer())
        subclass(Intrusion::class, Intrusion.serializer())
        subclass(MrJackVisibility::class, MrJackVisibility.serializer())
        subclass(PlayerEvent::class, PlayerEvent.serializer())
        subclass(UsernameRole::class, UsernameRole.serializer())
        subclass(WhoIsJack::class, WhoIsJack.serializer())
        subclass(Winner::class, Winner.serializer())
        subclass(UsernameWrapper::class, UsernameWrapper.serializer())
    }
}
