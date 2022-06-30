package model

import logic.Game
import removeRandom

object CardDealer {

    private var previousLeftCards: MutableList<Character> = ArrayList()

    fun deal(): List<Character> = if (Game.turn % 2 == 1) {
        val leftCards = Character.values().toMutableList().also { it.shuffle() }
        previousLeftCards.clear()
        for (i in 1..4) {
            previousLeftCards.add(leftCards.removeRandom())
        }
        leftCards
    } else previousLeftCards

}
