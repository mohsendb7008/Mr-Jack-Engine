import model.Position

infix fun Int.pos(other: Int) = Position(this, other)

fun <T> MutableList<T>.removeRandom() = removeAt((0 until size).random())

fun <T> List<T>.toPair() = component1() to component2()
