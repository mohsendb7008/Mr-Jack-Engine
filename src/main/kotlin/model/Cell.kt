package model

sealed class Cell(val position: Position, val adjacentPositions : List<Position> = emptyList(), var character: Character? = null) {

    val adjacents: List<Cell>
        get() = adjacentPositions.map { Board.cells[it]!! }

}