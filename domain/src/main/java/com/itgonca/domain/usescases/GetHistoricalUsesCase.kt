package com.itgonca.domain.usescases

import com.itgonca.data.respository.HistoricalRepository
import javax.inject.Inject

class GetHistoricalUsesCase @Inject constructor(private val historicalRepository: HistoricalRepository) {
    suspend fun getHistorical() = historicalRepository.getHistorical()
}