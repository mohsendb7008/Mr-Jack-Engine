package qa

import exception.mustBeEqualTo
import org.junit.Test
import model.Character

class WhoIsJackTest {

    @Test
    fun test() {
        val character = Character.values().random()
        val instance = WhoIsJack(character = character)
        val text = instance.toJson()
        println(text)
        val instanceFromJson = WhoIsJack.fromJson(text)
        instanceFromJson mustBeEqualTo instance
    }

}