package qa

import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import serializers.json

@Serializable
data class MrJackVisibility(val isVisible: Boolean): QA() {
    override val code = 6
    override val description = "Mr Jack is${if (isVisible) " " else " not "}visible."

}

fun MrJackVisibility.Companion.fromJson(input: String) = json.decodeFromString<MrJackVisibility>(input)

fun MrJackVisibility.toJson() = json.encodeToString(this)