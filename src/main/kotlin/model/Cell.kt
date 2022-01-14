package model

sealed class Cell(val position: Position, val adjacents : List<Position> = emptyList(), var character: Character? = null)