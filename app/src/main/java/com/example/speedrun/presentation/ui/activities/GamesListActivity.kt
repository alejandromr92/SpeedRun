package com.example.speedrun.presentation.ui.activities

import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.example.speedrun.R
import com.example.speedrun.domain.interactor.impl.GetGamesListInteractorImpl
import com.example.speedrun.domain.model.GameData
import com.example.speedrun.presentation.presenter.GetGamesListPresenter
import com.example.speedrun.presentation.presenter.impl.GetGamesListPresenterImpl
import com.example.speedrun.presentation.ui.adapters.GameListAdapter
import com.example.speedrun.utils.LoggerUtils
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_games_list.*

class GamesListActivity : BaseActivity(),
GetGamesListPresenter.View {

    private lateinit var getGamesListPresenter: GetGamesListPresenter

    private var gamesList: MutableList<GameData> = mutableListOf()

    private lateinit var gameListAdapter: GameListAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        this.layout = R.layout.activity_games_list

        super.onCreate(savedInstanceState)
    }

    override fun initializePresenters() {
        super.initializePresenters()

        this.getGamesListPresenter = GetGamesListPresenterImpl(
            GetGamesListInteractorImpl(AndroidSchedulers.mainThread(), Schedulers.newThread()),
            this
        )
    }

    override fun configViews() {
        super.configViews()

        configRecyclerView()
    }

    private fun configRecyclerView(){
        val layoutManager = LinearLayoutManager(this)
        games_recyclerview.layoutManager = layoutManager

        val dividerItemDecoration = DividerItemDecoration(games_recyclerview.context, layoutManager.orientation)
        games_recyclerview.addItemDecoration(dividerItemDecoration)

        this.gameListAdapter = GameListAdapter(gamesList as List<GameData>)
        games_recyclerview.adapter = gameListAdapter

    }

    override fun loadData() {
        super.loadData()

        this.getGamesListPresenter.getGamesList()
    }

    override fun displayContent(success: Boolean) {
        super.displayContent(success)

        if (success){
            games_recyclerview.visibility = View.VISIBLE
            gameListAdapter.notifyDataSetChanged()
        } else {
            //TODO
        }
    }

    // Callbacks
    override fun onGamesListRetrieved(gamesDataList: List<GameData>) {
        gamesList.addAll(gamesDataList)

        displayContent(true)
        hideProgress()
    }

    override fun onGamesListRetrievingError() {
        displayContent(false)
        LoggerUtils.logMessage("GAMES", "Error")
        hideProgress()
    }

}
