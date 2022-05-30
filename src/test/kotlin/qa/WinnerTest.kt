package qa

import exception.mustBeEqualTo
import model.Role
import org.junit.Test

class WinnerTest {

    @Test
    fun test() {
        val role = Role.values().random()
        val instance = Winner(role = role)
        val text = instance.toJson()
        println(text)
        val instanceFromJson = Winner.fromJson(text)
        instanceFromJson mustBeEqualTo instance
    }

}