package com.example.speedrun.di

import com.example.speedrun.network.api.impl.SpeedRunAPIImpl
import com.example.speedrun.network.service.SpeedrunService
import dagger.Component

@Component (modules = [NetworkModule::class])
interface NetworkComponent {

    fun getSpeedrunService(): SpeedrunService

    fun getSpeedrunAPI(): SpeedRunAPIImpl
}