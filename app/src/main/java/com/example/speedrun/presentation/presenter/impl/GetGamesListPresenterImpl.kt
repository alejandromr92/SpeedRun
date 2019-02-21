package com.example.speedrun.presentation.presenter.impl

import com.example.speedrun.domain.interactor.GetGamesListInteractor
import com.example.speedrun.domain.model.GameData
import com.example.speedrun.presentation.presenter.GetGamesListPresenter

class GetGamesListPresenterImpl(
    private val interactor: GetGamesListInteractor,
    private val view: GetGamesListPresenter.View
) : GetGamesListPresenter {


    override fun getGamesList() {
        view.showProgress()
        interactor.execute(::onGamesListRetrieved, ::onGamesListRetrievingError)
    }

    private fun onGamesListRetrieved(gamesList: List<GameData>){
        if (gamesList.isNullOrEmpty()){
            view.onGamesListRetrievingError()
        } else {
            view.onGamesListRetrieved(gamesList)
        }
    }

    private fun onGamesListRetrievingError(throwable: Throwable){
        view.onGamesListRetrievingError()
    }
}