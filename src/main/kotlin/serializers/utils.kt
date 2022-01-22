package serializers

import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

@Serializable
open class Deserializable {
    fun deserialize(input: String): Deserializable = Json.decodeFromString(input)
}