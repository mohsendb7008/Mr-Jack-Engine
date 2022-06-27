
import io.ktor.network.selector.SelectorManager
import io.ktor.network.sockets.aSocket
import kotlinx.coroutines.Dispatchers
import logic.Player
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
    val player1 = (p1.receive() as UsernameWrapper).username
    logger.debug("Player1 username is $player1")
    p2.send(UsernameRole(Role.Sherlock))
    val player2 = (p2.receive() as UsernameWrapper).username
    logger.debug("Player2 username is $player2")
}
