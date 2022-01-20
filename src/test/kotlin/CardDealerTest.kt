import exception.Assert
import model.CardDealer
import model.Character
import model.Game
import kotlin.test.Test

class CardDealerTest {

    @Test
    fun test() {
        val charactersSet = Character.values().toSet()
        Game.turn = 1
        repeat(100) {
            val characters = CardDealer.deal().toMutableSet()
            Game.turn++
            characters.addAll(CardDealer.deal())
            Game.turn++
            Assert.thatEquals(characters, charactersSet)
        }
    }

}