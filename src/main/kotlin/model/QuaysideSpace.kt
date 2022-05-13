package model

import pos

class QuaysideSpace private constructor(
    position: Position, vararg adjacentPositions: Position
) : Cell(position, adjacentPositions.toList()) {

    companion object {

        val cells = listOf(
            QuaysideSpace(1 pos 8, 1 pos 10, 2 pos 7, 2 pos 9, 0 pos 0),
            QuaysideSpace(3 pos 6, 2 pos 7, 3 pos 8, 4 pos 5, 4 pos 7, 0 pos 0),
            QuaysideSpace(5 pos 16, 4 pos 15, 5 pos 14, 6 pos 15),
            QuaysideSpace(7 pos 2, 6 pos 3, 7 pos 4, 8 pos 3)
        ).associateBy { it.position }

    }

}
