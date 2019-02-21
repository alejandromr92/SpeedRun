package com.example.speedrun.presentation.ui.activities

import android.os.Bundle
import com.example.speedrun.R
import com.example.speedrun.domain.interactor.impl.GetGameRunInteractorImpl
import com.example.speedrun.domain.interactor.impl.GetPlayerInteractorImpl
import com.example.speedrun.domain.model.GameData
import com.example.speedrun.domain.model.GameRunData
import com.example.speedrun.domain.model.PlayerData
import com.example.speedrun.presentation.Constants
import com.example.speedrun.presentation.extensions.load
import com.example.speedrun.presentation.presenter.GetGameRunPresenter
import com.example.speedrun.presentation.presenter.GetPlayerPresenter
import com.example.speedrun.presentation.presenter.impl.GetGameRunPresenterImpl
import com.example.speedrun.presentation.presenter.impl.GetPlayerPresenterImpl
import com.example.speedrun.utils.LoggerUtils
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_game_run_detail.*

class GameDetailActivity : BaseActivity(),
    GetGameRunPresenter.View, GetPlayerPresenter.View {

    private lateinit var getGameRunPresenter: GetGameRunPresenter
    private lateinit var getPlayerPresenter: GetPlayerPresenter

    private lateinit var gameData: GameData

    override fun onCreate(savedInstanceState: Bundle?) {
        this.layout = R.layout.activity_game_run_detail

        super.onCreate(savedInstanceState)

        gameData = intent.getParcelableExtra(Constants.SELECTED_GAME_KEY)
    }


    override fun initializePresenters() {
        super.initializePresenters()

        getGameRunPresenter = GetGameRunPresenterImpl(
            GetGameRunInteractorImpl(AndroidSchedulers.mainThread(), Schedulers.newThread()),
            this
        )

        getPlayerPresenter = GetPlayerPresenterImpl(
            GetPlayerInteractorImpl(AndroidSchedulers.mainThread(), Schedulers.newThread()),
            this
        )
    }

    override fun loadData() {
        super.loadData()

        getGameRunPresenter.getGameRun(gameData.gameId)


    }

    override fun onGameRunRetrieved(gameRunData: GameRunData) {
        game_detail_title.text = gameData.title
        game_detail_logo.load(gameData.logoUri)
        game_detail_time.text = gameRunData.runTime
        game_detail_view_speedrun_btn.setOnClickListener {
            //TODO add youtube link here
        }

        getPlayerPresenter.getPlayer(gameRunData.playerId)
    }

    override fun onGamesRunRetrievingError() {
        LoggerUtils.logMessage("GAME DETAIL", "Error game run")
    }

    override fun onPlayerRetrieved(playerData: PlayerData) {
        game_detail_player.text = playerData.name
    }

    override fun onPlayerRetrievingError() {
        LoggerUtils.logMessage("GAME DETAIL", "Error player data")
    }
}
