package logic

import io.ktor.network.sockets.Socket
import io.ktor.network.sockets.openReadChannel
import io.ktor.network.sockets.openWriteChannel
import io.ktor.utils.io.ByteReadChannel
import io.ktor.utils.io.ByteWriteChannel
import io.ktor.utils.io.readUTF8Line
import io.ktor.utils.io.writeStringUtf8
import qa.QA
import qa.fromJson
import qa.toJson

class Player(private val socket: Socket) {
    private val readChannel: ByteReadChannel by lazy {
        socket.openReadChannel()
    }
    private val writeChannel: ByteWriteChannel by lazy {
        socket.openWriteChannel(autoFlush = true)
    }
    suspend fun send(qa: QA) {
        writeChannel.writeStringUtf8("${qa.toJson()}\n")
    }
    suspend fun receive(): QA {
        return QA.fromJson(readChannel.readUTF8Line()!!)
    }
    fun close() {
        socket.close()
    }
}
