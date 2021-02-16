package com.itgonca.data.datasource.remote

import com.itgonca.data.datasource.remote.model.HistoricalResponse
import com.itgonca.data.datasource.remote.service.HistoricalApi
import javax.inject.Inject

class HistoricalRemoteDataSource @Inject constructor(private val historicalApi: HistoricalApi) {
    suspend fun getHistoricalApi(dateParam: String): HistoricalResponse =
        historicalApi.getHistorical(
            dateParam,
            RetrofitInstance.API_KEY
        )
}