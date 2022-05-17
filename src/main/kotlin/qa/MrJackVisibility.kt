package qa

import kotlinx.serialization.Serializable

@Serializable
class MrJackVisibility(val isVisible: Boolean): QA() {
    override val code = 6
    override val description = "Mr Jack is${if (isVisible) " " else " not "}visible."

}
