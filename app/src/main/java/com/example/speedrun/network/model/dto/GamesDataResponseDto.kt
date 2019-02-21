package com.example.speedrun.network.model.dto

import com.google.gson.annotations.SerializedName

data class GamesDataResponseDto (
    val data: List<GameDataDto>
)

data class GameDataDto(
    val id: String,
    val assets: GameAssets,
    val names: GameNames
)

data class GameNames(
    val international: String
)

data class GameAssets(
    @SerializedName("cover-large") val cover_large: GameCover
)

data class GameCover(
    val uri: String
)

data class GameRunResponseDto(
    val data: List<GameRunDto>
)

data class GameRunDto(
    val videos: GameRunVideoDto,
    val times: GameRunTimeDto,
    val players: List<GameRunPlayer>
)

data class GameRunVideoDto(
    val links: List<GameRunLink>
)

data class GameRunLink(
    val uri: String
)

data class GameRunTimeDto(
    val primary: String
)

data class GameRunPlayer(
    val id: String
)
