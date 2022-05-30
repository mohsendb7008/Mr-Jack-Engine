package qa

import exception.mustBeEqualTo
import org.junit.Test
import model.Character

class IntrusionTest {

    @Test
    fun test() {
        val character = Character.values().random()
        val instance = Intrusion(innocent = character)
        val text = instance.toJson()
        println(text)
        val instanceFromJson = Intrusion.fromJson(text)
        instanceFromJson mustBeEqualTo instance
    }

}