package com.example.speedrun.presentation.presenter

import com.example.speedrun.domain.model.PlayerData

interface GetPlayerPresenter {
    fun getPlayer(playerId: String)

    interface View: BaseView {
        fun onPlayerRetrieved(playerData: PlayerData)
        fun onPlayerRetrievingError()
    }
}