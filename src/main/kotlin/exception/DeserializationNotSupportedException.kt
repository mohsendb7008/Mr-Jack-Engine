package exception

class DeserializationNotSupportedException(className: String) : Exception("$className deserialization not supported")
