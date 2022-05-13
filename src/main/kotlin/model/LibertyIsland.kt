package model

import kotlinx.serialization.SerialName
import pos

@SerialName("LibertyIsland")
object LibertyIsland : Cell(0 pos 0, listOf(7 pos 2, 5 pos 16), informant = Informant)
