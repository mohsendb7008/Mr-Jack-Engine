package model

import kotlinx.serialization.Serializable

@Serializable
sealed class Cell(
    val position: Position,
    val adjacentPositions: List<Position> = emptyList(),
    var character: Character? = null,
    var informant: Informant? = null
) {
    val adjacents: List<Cell>
        get() = adjacentPositions.map { Board.cells[it]!! }

}
