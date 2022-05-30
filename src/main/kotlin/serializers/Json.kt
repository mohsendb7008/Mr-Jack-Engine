package serializers

import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import qa.action.characterActionSerializerModuleBuilder

val json = Json {
    encodeDefaults = true
    serializersModule = SerializersModule {
        cellSerializerModuleBuilder()
        characterActionSerializerModuleBuilder()
    }
    prettyPrint = true
    explicitNulls = false
}
