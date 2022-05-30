package qa

import exception.mustBeEqualTo
import org.junit.Test

class MrJackVisibilityTest {

    @Test
    fun test() {
        val instance = MrJackVisibility(isVisible = listOf(true, false).random())
        val text = instance.toJson()
        println(text)
        val instanceFromJson = MrJackVisibility.fromJson(text)
        instanceFromJson mustBeEqualTo instance
    }

}