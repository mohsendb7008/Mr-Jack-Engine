package serializers

import exception.mustBeEqualTo
import model.Tile
import org.junit.Test

class Tile {
    @Test
    fun serialize() {
        val tile = Tile.Park
        tile.toJson() mustBeEqualTo "{\"type\":\"${tile.name}\"}"
    }

    @Test
    fun deserialize() {
        val input = """
            { "type": "${Tile.GasLamp}" }
        """.trimIndent()
        Tile.deserialize(input) mustBeEqualTo Tile.GasLamp
    }
}
