package com.example.speedrun.network.service

interface Endpoints {
    companion object {
        const val BASE_URL = "https://www.speedrun.com/api/v1/"
        const val GAMES = "games"
        const val RUN = "runs"
    }
}