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

//TODO heredar de GameDataDto ^
data class GameRunDto(
    val title: String,
    val logoUri: String,
    val playerName: String,
    val runTime: String,
    val speedrunURL: String
)
