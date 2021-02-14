package com.itgonca.data.respository

interface HistoricalRepository {
    suspend fun getHistorical()
}