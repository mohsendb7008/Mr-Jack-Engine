package serializers

import kotlinx.serialization.json.Json

val json = Json {
    encodeDefaults = true
    serializersModule = cellSerializeModule
    prettyPrint = true
    explicitNulls = false
}
