package serializers

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

inline fun <reified T> T.serialize() = Json.encodeToString(this)