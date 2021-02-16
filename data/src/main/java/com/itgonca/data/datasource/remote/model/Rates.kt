package com.itgonca.data.datasource.remote.model


import com.google.gson.annotations.SerializedName

data class Rates(
    @SerializedName("CNY")
    val cny: Double,
    @SerializedName("CAD")
    val cad: Double,
    @SerializedName("MXN")
    val mxn: Double,
    @SerializedName("GBP")
    val gbp: Double,
    @SerializedName("USD")
    val usd: Double,
    @SerializedName("EUR")
    val eur: Double
)