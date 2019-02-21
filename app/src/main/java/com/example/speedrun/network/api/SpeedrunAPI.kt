package com.example.speedrun.network.api

import com.example.speedrun.domain.model.GameData
import com.example.speedrun.domain.model.GameRunData
import com.example.speedrun.domain.model.PlayerData
import com.example.speedrun.network.model.dto.GameRunRequest
import com.example.speedrun.network.model.dto.PlayerRequest
import io.reactivex.Single

interface SpeedrunAPI {
    fun getGames(): Single<List<GameData>>
    fun getGameRun(request: GameRunRequest): Single<GameRunData>
    fun getPlayer(request: PlayerRequest): Single<PlayerData>
}