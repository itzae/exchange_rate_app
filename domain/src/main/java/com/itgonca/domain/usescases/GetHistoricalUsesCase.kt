package com.itgonca.domain.usescases

import com.itgonca.data.respository.HistoricalRepository

class GetHistoricalUsesCase(private val historicalRepository: HistoricalRepository) {
    suspend fun getHistorical() = historicalRepository.getHistorical()
}