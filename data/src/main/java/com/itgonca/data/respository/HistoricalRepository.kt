package com.itgonca.data.respository

import com.itgonca.data.datasource.remote.model.HistoricalResponse

/**
 * @author Itzae González Castillo
 */
interface HistoricalRepository {
    suspend fun getHistorical():HistoricalResponse
}