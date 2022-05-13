package model

import kotlinx.serialization.Serializable
import pos
import serializers.StreetSpaceSerializer

@Serializable(with = StreetSpaceSerializer::class)
class StreetSpace internal constructor(
    position: Position,
    vararg adjacentPositions: Position,
    var tile: Tile? = null,
    val hasFixedTile: Boolean = false,
    character: Character? = null,
    var investigationTile: InvestigationTile? = null,
    informant: Informant? = null
) : Cell(position, adjacentPositions.toList(), character, informant) {

    companion object {

        val cells = listOf(
            StreetSpace(1 pos 10, 1 pos 8, 2 pos 9, 2 pos 11),
            StreetSpace(2 pos 7, 1 pos 8, 2 pos 9, 3 pos 6, 3 pos 8),
            StreetSpace(
                2 pos 9, 1 pos 8, 1 pos 10, 2 pos 7, 2 pos 11, 3 pos 8, 3 pos 10, tile = Tile.MetroEntrance
            ),
            StreetSpace(2 pos 11, 1 pos 10, 2 pos 9, 2 pos 13, 3 pos 10, 3 pos 12),
            StreetSpace(3 pos 8, 2 pos 7, 2 pos 9, 3 pos 6, 3 pos 10, 4 pos 7, 4 pos 9),
            StreetSpace(
                3 pos 10, 2 pos 9, 2 pos 11, 3 pos 8, 3 pos 12, 4 pos 9, 4 pos 11, tile = Tile.GasLamp
            ),
            StreetSpace(3 pos 12, 2 pos 11, 2 pos 13, 3 pos 10, 3 pos 14, 4 pos 11, 4 pos 13),
            StreetSpace(3 pos 14, 2 pos 13, 3 pos 12, 4 pos 13, 4 pos 15),
            StreetSpace(4 pos 5, 3 pos 6, 4 pos 7, 5 pos 4, 5 pos 6),
            StreetSpace(4 pos 7, 3 pos 6, 3 pos 8, 4 pos 5, 4 pos 9, 5 pos 6, 5 pos 8),
            StreetSpace(
                4 pos 9,
                3 pos 8,
                3 pos 10,
                4 pos 7,
                4 pos 11,
                5 pos 8,
                5 pos 10,
                tile = Tile.BuildingSite,
                hasFixedTile = true
            ),
            StreetSpace(
                4 pos 11,
                3 pos 10,
                3 pos 12,
                4 pos 9,
                4 pos 13,
                5 pos 10,
                5 pos 12,
                tile = Tile.BuildingSite,
                hasFixedTile = true
            ),
            StreetSpace(4 pos 13, 3 pos 12, 3 pos 14, 4 pos 11, 4 pos 15, 5 pos 12, 5 pos 14),
            StreetSpace(4 pos 15, 3 pos 14, 4 pos 13, 5 pos 14, 5 pos 16),
            StreetSpace(
                5 pos 4,
                4 pos 5,
                5 pos 2,
                5 pos 6,
                6 pos 3,
                6 pos 5,
                investigationTile = InvestigationTile.investigationTile1
            ),
            StreetSpace(5 pos 6, 4 pos 5, 4 pos 7, 5 pos 4, 5 pos 8, 6 pos 5, 6 pos 7),
            StreetSpace(
                5 pos 8, 4 pos 7, 4 pos 9, 5 pos 6, 5 pos 10, 6 pos 7, 6 pos 9, character = Character.LewisHowardLatimer
            ),
            StreetSpace(
                5 pos 10, 4 pos 9, 4 pos 11, 5 pos 8, 5 pos 12, 6 pos 9, 6 pos 11, character = Character.AlfredElyBeach
            ),
            StreetSpace(5 pos 12, 4 pos 11, 4 pos 13, 5 pos 10, 5 pos 14, 6 pos 11, 6 pos 13),
            StreetSpace(5 pos 14, 4 pos 13, 4 pos 15, 5 pos 12, 5 pos 16, 6 pos 13, 6 pos 15),
            StreetSpace(
                6 pos 3,
                5 pos 2,
                5 pos 4,
                6 pos 5,
                7 pos 2,
                7 pos 4,
                investigationTile = InvestigationTile.investigationTile1
            ),
            StreetSpace(6 pos 5, 5 pos 4, 5 pos 6, 6 pos 3, 6 pos 7, 7 pos 4, 7 pos 6),
            StreetSpace(6 pos 7, 5 pos 6, 5 pos 8, 6 pos 5, 6 pos 9, 7 pos 6, 7 pos 8),
            StreetSpace(
                6 pos 9, 5 pos 8, 5 pos 10, 6 pos 7, 6 pos 11, 7 pos 8, 7 pos 10, character = Character.JamesHCallahan
            ),
            StreetSpace(6 pos 11, 5 pos 10, 5 pos 12, 6 pos 9, 6 pos 13, 7 pos 10, 7 pos 12),
            StreetSpace(6 pos 13, 5 pos 12, 5 pos 14, 6 pos 11, 6 pos 15, 7 pos 12, 7 pos 14),
            StreetSpace(6 pos 15, 5 pos 14, 5 pos 16, 6 pos 13, 7 pos 14, 7 pos 16),
            StreetSpace(7 pos 4, 6 pos 3, 6 pos 5, 7 pos 2, 7 pos 6, 8 pos 3, 8 pos 5),
            StreetSpace(7 pos 6, 6 pos 5, 6 pos 7, 7 pos 4, 7 pos 8, 8 pos 5, 8 pos 7),
            StreetSpace(
                7 pos 8,
                6 pos 7,
                6 pos 9,
                7 pos 6,
                7 pos 10,
                8 pos 7,
                8 pos 9,
                tile = Tile.MetroEntrance,
                hasFixedTile = true
            ),
            StreetSpace(7 pos 10, 6 pos 9, 6 pos 11, 7 pos 8, 7 pos 12, 8 pos 9, 8 pos 11),
            StreetSpace(7 pos 12, 6 pos 11, 6 pos 13, 7 pos 10, 7 pos 14, 8 pos 11, 8 pos 13),
            StreetSpace(7 pos 14, 6 pos 13, 6 pos 15, 7 pos 12, 7 pos 16, 8 pos 13),
            StreetSpace(8 pos 3, 7 pos 2, 7 pos 4, 8 pos 5, 9 pos 2, 9 pos 4),
            StreetSpace(
                8 pos 5, 7 pos 4, 7 pos 6, 8 pos 3, 8 pos 7, 9 pos 4, 9 pos 6, character = Character.MonkEastman
            ),
            StreetSpace(8 pos 7, 7 pos 6, 7 pos 8, 8 pos 5, 8 pos 9, 9 pos 6, 9 pos 8),
            StreetSpace(8 pos 9, 7 pos 8, 7 pos 10, 8 pos 7, 8 pos 11, 9 pos 8, 9 pos 10),
            StreetSpace(
                8 pos 11,
                7 pos 10,
                7 pos 12,
                8 pos 9,
                8 pos 13,
                9 pos 10,
                9 pos 12,
                character = Character.FrancisJTumblety
            ),
            StreetSpace(8 pos 13, 7 pos 12, 7 pos 14, 8 pos 11, 9 pos 12),
            StreetSpace(9 pos 2, 8 pos 3, 9 pos 4, 10 pos 3),
            StreetSpace(9 pos 4, 8 pos 3, 8 pos 5, 9 pos 2, 9 pos 6, 10 pos 3, 10 pos 5),
            StreetSpace(9 pos 6, 8 pos 5, 8 pos 7, 9 pos 4, 9 pos 8, 10 pos 5, 10 pos 7),
            StreetSpace(
                9 pos 8, 8 pos 7, 8 pos 9, 9 pos 6, 9 pos 10, 10 pos 7, 10 pos 9, character = Character.CloudRider
            ),
            StreetSpace(9 pos 10, 8 pos 9, 8 pos 11, 9 pos 8, 9 pos 12, 10 pos 9, 10 pos 11),
            StreetSpace(9 pos 12, 8 pos 11, 8 pos 13, 9 pos 10, 10 pos 11, 10 pos 13),
            StreetSpace(10 pos 3, 9 pos 2, 9 pos 4, 10 pos 5, 11 pos 2, 11 pos 4),
            StreetSpace(
                10 pos 5,
                9 pos 4,
                9 pos 6,
                10 pos 3,
                10 pos 7,
                11 pos 4,
                11 pos 6,
                tile = Tile.BuildingSite,
                hasFixedTile = true
            ),
            StreetSpace(
                10 pos 7, 9 pos 6, 9 pos 8, 10 pos 5, 10 pos 9, 11 pos 6, 11 pos 8, character = Character.MrsEmmaGrant
            ),
            StreetSpace(
                10 pos 9, 9 pos 8, 9 pos 10, 10 pos 7, 10 pos 11, 11 pos 8, 11 pos 10, character = Character.EdwardSmith
            ),
            StreetSpace(
                10 pos 11,
                9 pos 10,
                9 pos 12,
                10 pos 9,
                10 pos 13,
                11 pos 10,
                11 pos 12,
                tile = Tile.BuildingSite,
                hasFixedTile = true
            ),
            StreetSpace(10 pos 13, 9 pos 12, 10 pos 11, 11 pos 12, 11 pos 14),
            StreetSpace(11 pos 2, 10 pos 3, 11 pos 4, 12 pos 1, 12 pos 3),
            StreetSpace(
                11 pos 4, 10 pos 3, 10 pos 5, 11 pos 2, 11 pos 6, 12 pos 3, 12 pos 5, tile = Tile.MetroEntrance
            ),
            StreetSpace(
                11 pos 6,
                10 pos 5,
                10 pos 7,
                11 pos 4,
                11 pos 8,
                12 pos 5,
                12 pos 7,
                tile = Tile.BuildingSite,
                hasFixedTile = true
            ),
            StreetSpace(11 pos 8, 10 pos 7, 10 pos 9, 11 pos 6, 11 pos 10, 12 pos 7, 12 pos 9),
            StreetSpace(
                11 pos 10,
                10 pos 9,
                10 pos 11,
                11 pos 8,
                11 pos 12,
                12 pos 9,
                12 pos 11,
                tile = Tile.BuildingSite,
                hasFixedTile = true
            ),
            StreetSpace(11 pos 12, 10 pos 11, 10 pos 13, 11 pos 10, 11 pos 14, 12 pos 11, 12 pos 13),
            StreetSpace(
                11 pos 14,
                10 pos 13,
                11 pos 12,
                11 pos 16,
                12 pos 13,
                12 pos 15,
                investigationTile = InvestigationTile.investigationTile2
            ),
            StreetSpace(12 pos 3, 11 pos 2, 11 pos 4, 12 pos 1, 12 pos 5, 13 pos 2, 13 pos 4),
            StreetSpace(12 pos 5, 11 pos 4, 11 pos 6, 12 pos 3, 12 pos 7, 13 pos 4, 13 pos 6),
            StreetSpace(12 pos 7, 11 pos 6, 11 pos 8, 12 pos 5, 12 pos 9, 13 pos 6, 13 pos 8),
            StreetSpace(12 pos 9, 11 pos 8, 11 pos 10, 12 pos 7, 12 pos 11, 13 pos 8, 13 pos 10),
            StreetSpace(12 pos 11, 11 pos 10, 11 pos 12, 12 pos 9, 12 pos 13, 13 pos 10, 13 pos 12),
            StreetSpace(
                12 pos 13, 11 pos 12, 11 pos 14, 12 pos 11, 12 pos 15, 13 pos 12, 13 pos 14, tile = Tile.MetroEntrance
            ),
            StreetSpace(
                12 pos 15,
                11 pos 14,
                11 pos 16,
                12 pos 13,
                13 pos 14,
                13 pos 16,
                investigationTile = InvestigationTile.investigationTile2
            ),
            StreetSpace(13 pos 2, 12 pos 1, 12 pos 3, 13 pos 4),
            StreetSpace(13 pos 4, 12 pos 3, 12 pos 5, 13 pos 2, 13 pos 6),
            StreetSpace(13 pos 6, 12 pos 5, 12 pos 7, 13 pos 4, 13 pos 8),
            StreetSpace(13 pos 8, 12 pos 7, 12 pos 9, 13 pos 6, 13 pos 10),
            StreetSpace(13 pos 10, 12 pos 9, 12 pos 11, 13 pos 8, 13 pos 12, 14 pos 11),
            StreetSpace(
                13 pos 12, 12 pos 11, 12 pos 13, 13 pos 10, 13 pos 14, 14 pos 11, tile = Tile.GasLamp
            ),
            StreetSpace(13 pos 14, 12 pos 13, 12 pos 15, 13 pos 12, 13 pos 16),
            StreetSpace(13 pos 16, 12 pos 15, 13 pos 14)
        ).associateBy { it.position }

    }

}
