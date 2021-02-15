package com.itgonca.data.datasource.remote

import com.itgonca.data.datasource.remote.model.HistoricalResponse
import com.itgonca.data.datasource.remote.service.HistoricalApi
import javax.inject.Inject

class HistoricalRemoteDataSource @Inject  constructor(private val historicalApi: HistoricalApi) {
    suspend fun getHistoricalApi():HistoricalResponse = historicalApi.getHistorical("2013-03-16","d515fbc23b7a9e372b26cd2104f63ca3","USD")
}