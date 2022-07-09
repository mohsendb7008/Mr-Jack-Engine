package exception

import logic.Graph
import model.Cell
import model.Character

infix fun <T> T.mustBeEqualTo(other: T) {
    if (this != other) {
        throw NotEqualException(this, other)
    }
}

infix fun Character.mustBeAbleToMoveTo(target: Cell) {
    if (!Graph.canMove(this, target)) {
        throw InvalidMoveException(this, target)
    }
}