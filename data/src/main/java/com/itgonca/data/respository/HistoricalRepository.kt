package com.itgonca.data.respository

import com.itgonca.data.datasource.remote.model.HistoricalResponse

interface HistoricalRepository {
    suspend fun getHistorical():HistoricalResponse
}