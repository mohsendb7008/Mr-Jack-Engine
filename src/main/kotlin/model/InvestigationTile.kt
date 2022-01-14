package model

import pos

class InvestigationTile private constructor(var blockedCells: Pair<StreetSpace, StreetSpace>) {
    companion object {
        val InvestigationTile1 = InvestigationTile(StreetSpace.map[5 pos 4]!! to StreetSpace.map[6 pos 3]!!)
        val InvestigationTile2 = InvestigationTile(StreetSpace.map[11 pos 14]!! to StreetSpace.map[12 pos 15]!!)
    }
}