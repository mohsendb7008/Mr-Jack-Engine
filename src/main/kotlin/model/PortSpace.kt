package model

import pos

class PortSpace private constructor(position: Position, var hasSteamer: Boolean = false): Cell(position){
    companion object{
        val map = listOf(
            PortSpace(2 pos 13),
            PortSpace(5 pos 2, hasSteamer = true),
            PortSpace(7 pos 16),
            PortSpace(11 pos 16, hasSteamer = true),
            PortSpace(12 pos 1)
        ).associateBy { it.position }
    }
}