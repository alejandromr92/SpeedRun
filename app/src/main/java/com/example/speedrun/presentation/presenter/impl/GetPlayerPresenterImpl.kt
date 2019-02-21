package com.example.speedrun.presentation.presenter.impl

import com.example.speedrun.domain.interactor.GetPlayerInteractor
import com.example.speedrun.domain.model.PlayerData
import com.example.speedrun.presentation.presenter.GetPlayerPresenter

class GetPlayerPresenterImpl(
    private val interactor: GetPlayerInteractor,
    private val view: GetPlayerPresenter.View
) : GetPlayerPresenter{


    override fun getPlayer(playerId: String) {
        view.showProgress()
        interactor.execute(playerId, ::onPlayerRetrieved, ::onPlayerRetrievingError)
    }

    private fun onPlayerRetrieved(playerData: PlayerData){
        view.hideProgress()
        view.onPlayerRetrieved(playerData)
    }

    private fun onPlayerRetrievingError(throwable: Throwable){
        view.hideProgress()
        view.onPlayerRetrievingError()
    }
}