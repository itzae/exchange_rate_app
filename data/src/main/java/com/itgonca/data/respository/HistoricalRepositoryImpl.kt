package com.itgonca.data.respository

import com.itgonca.data.datasource.remote.HistoricalRemoteDataSource

class HistoricalRepositoryImpl(private val historicalRemote:HistoricalRemoteDataSource):HistoricalRepository {
    override suspend fun getHistorical() {
        historicalRemote.getHistoricalApi()
    }
}