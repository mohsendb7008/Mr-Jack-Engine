package model

import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
sealed class Cell(
    val position: Position,
    @Transient
    val adjacentPositions: List<Position> = emptyList(),
    var character: Character? = null,
    var informant: Informant? = null
) {
    val adjacents: List<Cell>
        get() = adjacentPositions.map { Board.cells[it]!! }

}
