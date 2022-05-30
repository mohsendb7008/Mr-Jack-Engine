package qa

import model.Board
import model.VisibilityStatus
import org.junit.Test
import model.Character

class GameTurnTest {

    @Test
    fun test() {
        GameTurn(
            round = 1,
            turn = 1,
            map = Board.cells.values.toList(),
            visibilityStatus = VisibilityStatus.values().random(),
            remainingCards = Character.values().toList()
        ).toJson().let(::println)
    }

}