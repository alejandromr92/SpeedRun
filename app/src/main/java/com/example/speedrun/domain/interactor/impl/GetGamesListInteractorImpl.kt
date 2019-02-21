package com.example.speedrun.domain.interactor.impl

import com.example.speedrun.di.DaggerNetworkComponent
import com.example.speedrun.domain.interactor.GetGamesListInteractor
import com.example.speedrun.domain.model.GameData
import io.reactivex.Scheduler
import io.reactivex.disposables.Disposables

class GetGamesListInteractorImpl(
    private val observeOn: Scheduler,
    private val subscribeOn: Scheduler
): GetGamesListInteractor {

    private var subscription = Disposables.empty()

    override fun execute(onComplete: (List<GameData>) -> Unit, onError: (Throwable) -> Unit) {

        subscription = DaggerNetworkComponent.builder().build().getSpeedrunAPI().getGames()
            .subscribeOn(subscribeOn)
            .observeOn(observeOn)
            .subscribe(onComplete, onError)
    }
}