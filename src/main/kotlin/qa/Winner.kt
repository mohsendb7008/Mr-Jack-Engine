package qa

import model.Role

class Winner(val role: Role): QA() {
    override val code = 8
    override val description = "$role won."
}
