package com.itgonca.data.datasource.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private const val BASE_URL = "http://data.fixer.io/api/"
    const val API_KEY = "d515fbc23b7a9e372b26cd2104f63ca3"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun <T> createService(cls: Class<out T>): T = retrofit.create(cls)
}