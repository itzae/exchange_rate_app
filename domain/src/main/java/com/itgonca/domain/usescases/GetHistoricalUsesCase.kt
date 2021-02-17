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
    suspend fun getHistorical(dateParam: String): List<Historical> {
        val listHistorical = mutableListOf<Historical>()
        historicalRepository.getHistorical(dateParam).rates.apply {
            listHistorical.add(Historical("USD", usd))
            listHistorical.add(Historical("CNY", cny))
            listHistorical.add(Historical("CAD", cad))
            listHistorical.add(Historical("MXN", mxn))
            listHistorical.add(Historical("GBP", gbp))
            listHistorical.add(Historical("EUR", eur))
            listHistorical.add(Historical("AED", aed))
            listHistorical.add(Historical("AFN", afn))
            listHistorical.add(Historical("ALL", all))
            listHistorical.add(Historical("BAM", bam))
            listHistorical.add(Historical("BBD", bbd))
            listHistorical.add(Historical("BDT", bdt))
            listHistorical.add(Historical("BGN", bgn))
            listHistorical.add(Historical("BRL", brl))
            listHistorical.add(Historical("CDF", cdf))
            listHistorical.add(Historical("CHF", chf))
            listHistorical.add(Historical("DKK", dkk))
            listHistorical.add(Historical("DOP", dop))
            listHistorical.add(Historical("DZD", dzd))
            listHistorical.add(Historical("EGP", egp))
            listHistorical.add(Historical("ETB", etb))
            listHistorical.add(Historical("FJD", fjd))
            listHistorical.add(Historical("FKP", fkp))
            listHistorical.add(Historical("GEL", gel))
            listHistorical.add(Historical("GHS", ghs))
            listHistorical.add(Historical("HKD", hkd))
            listHistorical.add(Historical("HNL", hnl))
            listHistorical.add(Historical("HRK", hrk))
            listHistorical.add(Historical("IDR", idr))
            listHistorical.add(Historical("ILS", ils))
            listHistorical.add(Historical("JEP", jep))
            listHistorical.add(Historical("JMD", jmd))
            listHistorical.add(Historical("KES", kes))
            listHistorical.add(Historical("KGS", kgs))
            listHistorical.add(Historical("LAK", lak))
            listHistorical.add(Historical("LBP", lbp))
            listHistorical.add(Historical("MAD", mad))
            listHistorical.add(Historical("PAB", pab))
            listHistorical.add(Historical("PEN", pen))
            listHistorical.add(Historical("QAR", qar))
            listHistorical.add(Historical("SAR", sar))
            listHistorical.add(Historical("SOS", sos))
            listHistorical.add(Historical("SZL", szl))
            listHistorical.add(Historical("XAF", xaf))
            listHistorical.add(Historical("YER", yer))
        }
        return listHistorical
    }
}