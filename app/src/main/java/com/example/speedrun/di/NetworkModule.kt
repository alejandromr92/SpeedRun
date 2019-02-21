package com.example.speedrun.di

import com.example.speedrun.network.Constants
import com.example.speedrun.network.api.impl.SpeedRunAPIImpl
import com.example.speedrun.network.interceptor.NonSecurityInterceptor
import com.example.speedrun.network.service.Endpoints
import com.example.speedrun.network.service.SpeedrunService
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
open class NetworkModule {

    @Provides
    fun providesSpeedrunAPI(): SpeedRunAPIImpl = SpeedRunAPIImpl()

    @Provides
    fun providesSpeedrunService(retrofit: Retrofit): SpeedrunService =
        retrofit.create(SpeedrunService::class.java)


    @Provides
    fun provideRetrofitClient(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .apply {
                addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                addConverterFactory(GsonConverterFactory.create())
                baseUrl(Endpoints.BASE_URL)
                client(okHttpClient)
            }
            .build()

    @Provides
    fun provideOkHttpClient(interceptor: Interceptor): OkHttpClient =
        OkHttpClient.Builder()
            .readTimeout(Constants.READ_TIME_OUT, TimeUnit.SECONDS)
            .connectTimeout(Constants.CONNECT_TIME_OUT, TimeUnit.SECONDS)
            .writeTimeout(Constants.WRITE_TIME_OUT, TimeUnit.SECONDS)
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .addInterceptor(interceptor)
            .build()

    @Provides
    fun provideHttpLoggingInterceptor(): Interceptor {
        return NonSecurityInterceptor()
    }
}