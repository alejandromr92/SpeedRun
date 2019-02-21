package com.example.speedrun.di

import com.example.speedrun.network.api.impl.SpeedRunAPIImpl
import com.example.speedrun.network.service.SpeedrunService
import dagger.Component
import javax.inject.Singleton

@Component (modules = [NetworkModule::class])
interface NetworkComponent {

    @Singleton
    fun getSpeedrunService(): SpeedrunService

    @Singleton
    fun getSpeedrunAPI(): SpeedRunAPIImpl

}