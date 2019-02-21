package com.example.speedrun.presentation.extensions

import android.content.Context
import android.content.Intent
import com.example.speedrun.domain.model.GameData
import com.example.speedrun.presentation.Constants
import com.example.speedrun.presentation.ui.activities.GameDetailActivity

fun Context.GameDetailIntent(gameData: GameData): Intent {
    return Intent(this, GameDetailActivity::class.java).apply {
        putExtra(Constants.SELECTED_GAME_KEY, gameData)
    }
}