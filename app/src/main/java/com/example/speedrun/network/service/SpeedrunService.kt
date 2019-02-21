package com.example.speedrun.network.service

import com.example.speedrun.network.Constants
import com.example.speedrun.network.model.dto.GameRunDto
import com.example.speedrun.network.model.dto.GameRunResponseDto
import com.example.speedrun.network.model.dto.GamesDataResponseDto
import com.example.speedrun.network.model.dto.PlayerResponseDto
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface SpeedrunService {

    @GET(Endpoints.GAMES)
    fun getGamesList(
    ) : Single<GamesDataResponseDto>

    @GET(Endpoints.RUN)
    fun getGameRun(
        @Query(Constants.GAME_ID) gameId: String
    ) : Single<GameRunResponseDto>

    @GET(Endpoints.USERS)
    fun getPlayerData(
        @Path("userId") playerId: String
    ) : Single<PlayerResponseDto>
}