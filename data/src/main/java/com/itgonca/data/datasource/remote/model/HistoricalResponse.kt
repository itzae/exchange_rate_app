package com.itgonca.data.datasource.remote.model


import com.google.gson.annotations.SerializedName

data class HistoricalResponse(
    @SerializedName("base")
    val base: String,
    @SerializedName("date")
    val date: String,
    @SerializedName("historical")
    val historical: Boolean,
    @SerializedName("rates")
    val rates: Rates,
    @SerializedName("success")
    val success: Boolean,
    @SerializedName("timestamp")
    val timestamp: Int
)