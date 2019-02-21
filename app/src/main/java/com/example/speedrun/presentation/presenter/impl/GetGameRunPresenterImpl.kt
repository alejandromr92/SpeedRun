package com.example.speedrun.presentation.presenter.impl

import com.example.speedrun.domain.interactor.GetGameRunInteractor
import com.example.speedrun.domain.model.GameRunData
import com.example.speedrun.presentation.presenter.GetGameRunPresenter

class GetGameRunPresenterImpl(
    private val interactor: GetGameRunInteractor,
    private val view: GetGameRunPresenter.View
) : GetGameRunPresenter{

    override fun getGameRun(gameId: String) {
        view.showProgress()
        interactor.execute(gameId, ::onGameRunRetrieved, ::onGameRunRetrievingError)
    }


    private fun onGameRunRetrieved(gameRunData: GameRunData){
        view.onGameRunRetrieved(gameRunData)
    }

    private fun onGameRunRetrievingError(throwable: Throwable){
        view.onGamesRunRetrievingError()
    }
}