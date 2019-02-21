package com.example.speedrun.domain.interactor.impl

import com.example.speedrun.di.DaggerNetworkComponent
import com.example.speedrun.domain.interactor.GetGameRunInteractor
import com.example.speedrun.domain.model.GameRunData
import com.example.speedrun.network.model.dto.GameRunRequest
import io.reactivex.Scheduler
import io.reactivex.disposables.Disposables

class GetGameRunInteractorImpl(
    private val observeOn: Scheduler,
    private val subscribeOn: Scheduler
): GetGameRunInteractor {
    private var subscription = Disposables.empty()

    override fun execute(gameId: String, onComplete: (GameRunData) -> Unit, onError: (Throwable) -> Unit) {
        subscription = DaggerNetworkComponent.builder().build().getSpeedrunAPI().getGameRun(GameRunRequest(gameId))
            .subscribeOn(subscribeOn)
            .observeOn(observeOn)
            .subscribe(onComplete, onError)
    }
}