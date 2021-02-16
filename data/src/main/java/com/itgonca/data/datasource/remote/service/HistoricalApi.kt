package com.itgonca.data.datasource.remote.service

import com.itgonca.data.datasource.remote.model.HistoricalResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface HistoricalApi {

    @GET("{date}?")
    suspend fun getHistorical(
        @Path("date") date: String,
        @Query("access_key") key: String
    ): HistoricalResponse
}