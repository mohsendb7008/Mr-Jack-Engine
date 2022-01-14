package model

import kotlin.random.Random

object CardDealer{
    private var previousCards: MutableList<Character> = ArrayList()

    fun deal(turn: Int): MutableList<Character> =
        if(turn % 2 == 0) {
            val leftCards = Character.values().toMutableList().also { it.shuffle() }
            previousCards.clear()
            for(i in 1..4)
                previousCards.add(leftCards.removeAt(Random(leftCards.size).nextInt()))
            leftCards
        } else previousCards
}