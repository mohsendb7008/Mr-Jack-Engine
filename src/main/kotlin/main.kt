
import exception.GameFinishedException
import io.ktor.network.selector.SelectorManager
import io.ktor.network.sockets.aSocket
import io.ktor.util.logging.*
import kotlinx.coroutines.Dispatchers
import logic.Player
import logic.Game
import model.Role
import mu.KotlinLogging
import qa.UsernameRole
import qa.UsernameWrapper

suspend fun main() {
    val logger = KotlinLogging.logger {  }
    val selectorManager = SelectorManager(Dispatchers.IO)
    val serverSocket = aSocket(selectorManager).tcp().bind("127.0.0.1", 9090)
    logger.info("Server started listening on port 9090")
    val p1 = Player(serverSocket.accept())
    logger.info("Player 1 connected")
    val p2 = Player(serverSocket.accept())
    logger.info("Player 2 connected")
    p1.send(UsernameRole(Role.Jack))
    p1.username = (p1.receive() as UsernameWrapper).username
    logger.debug("Player1 username is ${p1.username}")
    p2.send(UsernameRole(Role.Sherlock))
    p2.username = (p2.receive() as UsernameWrapper).username
    logger.debug("Player2 username is ${p2.username}")
    Game.init(p1, p2, logger)
    runCatching {
        Game.run()
    }.onFailure {
        if (it is GameFinishedException) {
            logger.info("Game finished without error.")
            return@onFailure
        }
        logger.error(it)
        Game.finish(if (Game.playerTurn == Role.Jack) Role.Sherlock else Role.Jack, it.message.toString(), true)
    }
}
