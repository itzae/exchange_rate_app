package com.itgonca.data.datasource.remote.service

import com.itgonca.data.datasource.remote.model.HistoricalResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface HistoricalApi {

    @GET("{date}{access_key}{symbols}")
    suspend fun getHistorical(@Path("date") date: String,@Path("access_key") key:String,@Path("symbols") symbols:String): HistoricalResponse
}