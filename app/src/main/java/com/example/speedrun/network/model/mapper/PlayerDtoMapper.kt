package com.example.speedrun.network.model.mapper

import com.example.speedrun.domain.model.PlayerData
import com.example.speedrun.network.model.dto.PlayerDataDto

abstract class PlayerDtoMapper {
    companion object {
        fun map(playerDataDto: PlayerDataDto): PlayerData =
            PlayerData(
                playerDataDto.names.international
            )
    }
}