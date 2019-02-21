package com.example.speedrun.domain.interactor.impl

import com.example.speedrun.di.DaggerNetworkComponent
import com.example.speedrun.domain.interactor.GetPlayerInteractor
import com.example.speedrun.domain.model.PlayerData
import com.example.speedrun.network.model.dto.PlayerRequest
import io.reactivex.Scheduler
import io.reactivex.disposables.Disposables

class GetPlayerInteractorImpl(
    private val observeOn: Scheduler,
    private val subscribeOn: Scheduler
): GetPlayerInteractor {
    private var subscription = Disposables.empty()

    override fun execute(playerId: String, onComplete: (PlayerData) -> Unit, onError: (Throwable) -> Unit) {
        subscription = DaggerNetworkComponent.builder().build().getSpeedrunAPI().getPlayer(PlayerRequest(playerId))
            .subscribeOn(subscribeOn)
            .observeOn(observeOn)
            .subscribe(onComplete, onError)
    }
}