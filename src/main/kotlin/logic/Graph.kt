package logic

import model.*

object Graph {

    private fun isBlocked(cell: Cell) = cell is StreetSpace && (cell.tile in listOf(Tile.GasLamp, Tile.BuildingSite) || cell.investigationTile != null)

    private fun dfs(current: Position, target: Cell, depth: Int): Boolean {
        if (depth > 3) {
            return false
        }
        val cell = Board.cells[current]!!
        if (isBlocked(cell)) {
            return false
        }
        if (depth != 0 && cell == target) {
            return true
        }
        for (adjacent in cell.adjacentPositions) {
            if (dfs(adjacent, target, depth + 1)) {
                return true
            }
        }
        return false
    }

    fun canMove(character: Character, target: Cell): Boolean {
        if (character.cell == target) {
            for (adjacent in character.cell.adjacentPositions) {
                val cell = Board.cells[adjacent]!!
                if (!isBlocked(cell)) {
                    return false
                }
            }
            return true
        }
        // TODO Handle Cloud Rider
        return dfs(character.cell.position, target, 0)
    }

}