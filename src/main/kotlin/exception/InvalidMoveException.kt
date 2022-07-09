package exception

import model.Cell
import model.Character

class InvalidMoveException(character: Character, target: Cell): Exception("$character cannot move to ${target.position}")