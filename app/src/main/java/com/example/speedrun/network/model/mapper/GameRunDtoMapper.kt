package com.example.speedrun.network.model.mapper

import com.example.speedrun.domain.model.GameRunData
import com.example.speedrun.network.model.dto.GameRunDto

abstract class GameRunDtoMapper {
    companion object {
        fun map(gameRunDto: GameRunDto): GameRunData =
            GameRunData(
                gameRunDto.players[0].id,
                gameRunDto.times.primary,
                gameRunDto.videos.links[0].uri
            )
    }
}