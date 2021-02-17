package com.itgonca.data.di

import com.itgonca.data.datasource.remote.RetrofitInstance
import com.itgonca.data.datasource.remote.service.HistoricalApi
import com.itgonca.data.respository.HistoricalRepository
import com.itgonca.data.respository.HistoricalRepositoryImpl
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class DataModule {

    @Provides
    fun provideDataResource(historicalRepository: HistoricalRepositoryImpl): HistoricalRepository =
        historicalRepository

    @Provides
    fun provideHistoricalApi():HistoricalApi = RetrofitInstance.createService(HistoricalApi::class.java)
}