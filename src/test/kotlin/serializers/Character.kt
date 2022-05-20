package serializers

import exception.mustBeEqualTo
import model.Character
import org.junit.Test

class Character {
    @Test
    fun serialize() {
        val character = Character.AlfredElyBeach
        val output = """
            {"type":"${character.name}","isSuspect":${character.isSuspect}}
        """.trimIndent()
        output mustBeEqualTo character.toJson()
    }

    @Test
    fun deserialize() {
        val character = Character.FrancisJTumblety
        val input = """
            {
                "type": "${character.name}"
            }
        """.trimIndent()
        Character.fromJson(input) mustBeEqualTo character
    }
}
