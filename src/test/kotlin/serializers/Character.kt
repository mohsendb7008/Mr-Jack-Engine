package serializers

import exception.mustBeEqualTo
import model.Character
import org.junit.Test

class Character {
    @Test
    fun serialize() {
        val character = Character.AlfredElyBeach
        val output = """
            {"type":"${character.name}","isVisible":${character.isVisible},"isSuspect":${character.isSuspect}}
        """.trimIndent()
        output mustBeEqualTo character.serialize()
    }

    @Test
    fun deserialize() {
        val character = Character.FrancisJTumblety
        val input = """
            {
                "type": "${character.name}",
                "isVisible": ${character.isVisible},
                "isSuspect": ${character.isSuspect}
            }
        """.trimIndent()
        Character.deserialize(input) mustBeEqualTo character
    }
}