package exception

object Assert {

    fun <T> thatEquals(a: T, b: T) {
        if (a != b) {
            throw NotEqualException(a, b)
        }
    }

}