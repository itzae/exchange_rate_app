package com.itgonca.data.respository

import com.itgonca.data.datasource.remote.HistoricalRemoteDataSource
import javax.inject.Inject

class HistoricalRepositoryImpl @Inject constructor(private val historicalRemote: HistoricalRemoteDataSource) :
    HistoricalRepository {
    override suspend fun getHistorical(dateParam:String) = historicalRemote.getHistoricalApi(dateParam)

}