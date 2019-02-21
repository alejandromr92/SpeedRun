package com.example.speedrun.domain.interactor

import com.example.speedrun.domain.model.GameData

interface GetGamesListInteractor {
    fun execute(onComplete: (List<GameData>) -> Unit, onError: (Throwable) -> Unit)
}