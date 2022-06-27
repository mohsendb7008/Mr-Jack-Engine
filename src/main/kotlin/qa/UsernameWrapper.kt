package qa

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import serializers.json

@Serializable
@SerialName("UsernameWrapper")
data class UsernameWrapper(val username: String): QA() {
    override val description = "My username is $username."
}

fun UsernameWrapper.fromJson(input: String) = json.decodeFromString<UsernameWrapper>(input)

fun UsernameWrapper.toJson() = json.encodeToString(this)
