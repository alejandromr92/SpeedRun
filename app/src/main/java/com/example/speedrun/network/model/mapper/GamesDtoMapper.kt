package com.example.speedrun.network.model.mapper

import com.example.speedrun.domain.model.GameData
import com.example.speedrun.network.model.dto.GameDataDto
import java.util.*

abstract class GamesDtoMapper {
    companion object {
        fun map(gamesDataList: List<GameDataDto>): List<GameData> {
            val list = ArrayList<GameData>()

            if (gamesDataList.isNotEmpty()){
                for (bd in gamesDataList){
                    list.add(map(bd))
                }
            }

            return list
        }

        fun map(dto: GameDataDto) = GameData(
            dto.id,
            dto.names.international,
            dto.assets.cover_large.uri
        )
    }
}