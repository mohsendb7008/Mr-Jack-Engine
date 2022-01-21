package exception

infix fun <T> T.mustBeEqualTo(other: T) {
    if (this != other) {
        throw NotEqualException(this, other)
    }
}