package com.itgonca.data.datasource.remote.service

import retrofit2.http.GET

interface HistoricalApi {

    @GET()
    suspend fun getHistorical()
}