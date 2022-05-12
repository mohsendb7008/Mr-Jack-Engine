package qa.action

import model.Position

class JamesHCallahanAction(val id: Int, val positions: Pair<Position, Position>): CharacterAction {
    init {
        require(id in 1..2)
    }
}
