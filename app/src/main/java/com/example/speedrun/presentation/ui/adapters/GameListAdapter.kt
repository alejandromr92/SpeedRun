package com.example.speedrun.presentation.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.speedrun.R
import com.example.speedrun.domain.model.GameData
import com.example.speedrun.presentation.ui.adapters.holders.GameHolder
import com.example.speedrun.presentation.ui.adapters.holders.OnGameSelected

class GameListAdapter(private val items: List<GameData>, private val listener: OnGameSelected) :
    RecyclerView.Adapter<GameHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_game, parent, false)

        return GameHolder(view)
    }

    override fun onBindViewHolder(holder: GameHolder, position: Int) {
        holder.bind(items[position], listener)
    }

    override fun getItemCount(): Int {
        return items.size
    }

}
