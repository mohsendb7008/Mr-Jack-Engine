package serializers

import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import qa.action.characterActionSerializerModuleBuilder
import qa.qaSerializerModuleBuilder

val json = Json {
    encodeDefaults = true
    serializersModule = SerializersModule {
        qaSerializerModuleBuilder()
        cellSerializerModuleBuilder()
        characterActionSerializerModuleBuilder()
    }
//    prettyPrint = true
    explicitNulls = false
}
