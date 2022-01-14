import model.Position

infix fun Int.pos(other: Int) = Position(this, other)