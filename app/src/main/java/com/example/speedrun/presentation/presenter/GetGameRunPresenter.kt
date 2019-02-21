package com.example.speedrun.presentation.presenter

import com.example.speedrun.domain.model.GameRunData

interface GetGameRunPresenter {
    fun getGameRun(gameId: String)

    interface View: BaseView {
        fun onGameRunRetrieved(gameRunData: GameRunData)
        fun onGamesRunRetrievingError()
    }
}