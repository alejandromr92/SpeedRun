package com.example.speedrun.network.model.dto

data class PlayerResponseDto(
    val data: PlayerDataDto
)

data class PlayerDataDto(
    val names: PlayerNames
)

data class PlayerNames(
    val international: String
)