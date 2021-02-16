package com.itgonca.domain.usescases

import com.itgonca.data.respository.HistoricalRepository
import com.itgonca.domain.model.Historical
import javax.inject.Inject

/**
 * @author Itzae González Castillo
 *
 * This class is in charge of managing the business logic when obtaining the history of certain
 * specific currencies
 * @param historicalRepository this is an instance of [HistoricalRepository]
 */
class GetHistoricalUsesCase @Inject constructor(private val historicalRepository: HistoricalRepository) {

    /**
     * This method obtains and processes the result of the request to obtain the history and be sent
     * to the viewModel
     * @return [List]
     */
    suspend fun getHistorical(dateParam:String): List<Historical> {
        val listHistorical = mutableListOf<Historical>()
        historicalRepository.getHistorical(dateParam).rates.apply {
            listHistorical.add(Historical("USD", usd))
            listHistorical.add(Historical("CNY", cny))
            listHistorical.add(Historical("CAD", cad))
            listHistorical.add(Historical("MXN", mxn))
            listHistorical.add(Historical("GBP", gbp))
            listHistorical.add(Historical("EUR", eur))
        }
        return listHistorical
    }
}