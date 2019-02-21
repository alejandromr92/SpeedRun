package com.example.speedrun.domain.interactor

import com.example.speedrun.domain.model.GameRunData

interface GetGameRunInteractor {
    fun execute(gameId: String, onComplete: (GameRunData) -> Unit, onError: (Throwable) -> Unit)
}