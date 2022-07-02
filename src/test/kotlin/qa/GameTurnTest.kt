package qa

import model.Board
import org.junit.Test
import model.Character

class GameTurnTest {

    @Test
    fun test() {
        GameTurn(
            round = 1,
            turn = 1,
            map = Board.cells.values.toList(),
            remainingCards = Character.values().toList()
        ).toJson().let(::println)
    }

}