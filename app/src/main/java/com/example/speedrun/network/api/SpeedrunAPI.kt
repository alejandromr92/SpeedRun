package com.example.speedrun.network.api

import com.example.speedrun.domain.model.GameData
import com.example.speedrun.domain.model.GameRunData
import com.example.speedrun.network.model.dto.GameRunRequest
import io.reactivex.Single

interface SpeedrunAPI {
    fun getGames(): Single<List<GameData>>
    fun getGameRun(request: GameRunRequest): Single<GameRunData>
}