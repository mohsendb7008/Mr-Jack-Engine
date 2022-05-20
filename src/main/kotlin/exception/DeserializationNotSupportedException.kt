package exception

class DeserializationNotSupportedException(className: String) : Exception("$className deserialization is not supported")
