package com.itgonca.data.datasource.remote

import com.itgonca.data.datasource.remote.service.HistoricalApi

class HistoricalRemoteDataSource(private val historicalApi: HistoricalApi) {
    suspend fun getHistoricalApi() = historicalApi.getHistorical()
}