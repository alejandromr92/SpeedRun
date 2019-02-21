package com.example.speedrun.presentation.ui.adapters.holders

import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.speedrun.domain.model.GameData
import com.example.speedrun.presentation.extensions.load
import kotlinx.android.synthetic.main.item_game.view.*

class GameHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(holder: GameData) = with(itemView){

        item_game_logo.load(holder.logoUri)

        item_game_title.text = holder.title
    }
}
