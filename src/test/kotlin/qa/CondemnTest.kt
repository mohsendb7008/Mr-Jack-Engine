package qa

import exception.mustBeEqualTo
import org.junit.Test
import model.Character

class CondemnTest {

    @Test
    fun test() {
        val character = Character.values().random()
        val instance = Condemn(character = character)
        val text = instance.toJson()
        println(text)
        val instanceFromJson = Condemn.fromJson(text)
        instanceFromJson mustBeEqualTo instance
    }

}