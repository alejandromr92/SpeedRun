package com.example.speedrun.domain.interactor

import com.example.speedrun.domain.model.PlayerData

interface GetPlayerInteractor {
    fun execute(playerId: String, onComplete: (PlayerData) -> Unit, onError: (Throwable) -> Unit)
}