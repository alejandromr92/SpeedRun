package com.example.speedrun.network.api.impl

import com.example.speedrun.di.DaggerNetworkComponent
import com.example.speedrun.domain.model.GameData
import com.example.speedrun.domain.model.GameRunData
import com.example.speedrun.network.api.SpeedrunAPI
import com.example.speedrun.network.model.dto.GameRunRequest
import com.example.speedrun.network.model.mapper.GameRunDtoMapper
import com.example.speedrun.network.model.mapper.GamesDtoMapper
import com.example.speedrun.network.service.SpeedrunService
import io.reactivex.Single

class SpeedRunAPIImpl: SpeedrunAPI{
    private val service: SpeedrunService = DaggerNetworkComponent.builder().build().getSpeedrunService()

    override fun getGames(): Single<List<GameData>>
            = service.getGamesList().map { GamesDtoMapper.map(it.data) }

    override fun getGameRun(request: GameRunRequest): Single<GameRunData>
            = service.getGameRun(request.id).map { GameRunDtoMapper.map(it) }

}

