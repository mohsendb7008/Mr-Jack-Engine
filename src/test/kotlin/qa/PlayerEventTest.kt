package qa

import exception.mustBeEqualTo
import org.junit.Test
import model.Character
import model.Position
import qa.action.*
import toPair

class PlayerEventTest {

    @Test
    fun test() {
        Character.values().forEach { selectedCard ->
            val move = Position(1, 1)
            val action = when (selectedCard) {
                Character.AlfredElyBeach -> AlfredElyBeachAction(
                    metroPlace = Position(1, 2)
                )
                Character.CloudRider -> CloudRiderAction(
                    buildingPlace = Position(1, 2)
                )
                Character.LewisHowardLatimer -> HowardLatimerAction(
                    gasLightPlace = Position(1, 2)
                )
                Character.MrsEmmaGrant -> EmmaGrantAction(
                    parkPlace = Position(1, 2)
                )
                Character.JamesHCallahan -> JamesHCallahanAction(
                    id = 1,
                    position = Position(1, 2)
                )
                Character.MonkEastman -> MonkEastmanAction(
                    character = Character.values().random()
                )
                Character.FrancisJTumblety -> FrancisJTumbletyAction(
                    characters = Character.values().toList().shuffled().take(2).toPair().takeIf { (1..2).random() == 1 }
                )
                Character.EdwardSmith -> EdwardSmithAction(
                    from = Position(1, 2),
                    to = Position(1, 3)
                )
            }
            val order = PlayerEvent.EventOrder.values().random()
            val informantPosition = Position(1, 4).takeIf { selectedCard == Character.MrsEmmaGrant }
            val instance = PlayerEvent(
                selectedCard = selectedCard,
                move = move,
                action = action,
                order = order,
                informantPosition = informantPosition
            )
            val text = instance.toJson()
            println(text)
            val instanceFromJson = PlayerEvent.fromJson(text)
            instanceFromJson mustBeEqualTo instance
        }
    }

}