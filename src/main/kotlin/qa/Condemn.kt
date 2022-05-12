package qa

import model.Character

class Condemn(val character: Character): QA() {
    override val code = 7
    override val description = "Sherlock believes that $character is Mr Jack."
}
