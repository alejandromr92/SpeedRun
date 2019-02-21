package com.example.speedrun.presentation.presenter

import com.example.speedrun.domain.model.GameData

interface GetGamesListPresenter {
    fun getGamesList()

    interface View: BaseView {
        fun onGamesListRetrieved(gamesList: List<GameData>)
        fun onGamesListRetrievingError()
    }
}