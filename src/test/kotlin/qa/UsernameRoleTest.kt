package qa

import exception.mustBeEqualTo
import model.Role
import org.junit.Test

class UsernameRoleTest {

    @Test
    fun test() {
        val role = Role.values().random()
        val instance = UsernameRole(role = role)
        val text = instance.toJson()
        println(text)
        val instanceFromJson = UsernameRole.fromJson(text)
        instanceFromJson mustBeEqualTo instance
    }

}