package model

import kotlinx.serialization.Serializable

@Serializable
data class Position(val column: Int, val row: Int)