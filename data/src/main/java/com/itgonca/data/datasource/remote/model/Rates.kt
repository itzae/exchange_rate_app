package com.itgonca.data.datasource.remote.model


import com.google.gson.annotations.SerializedName

data class Rates(
    @SerializedName("AUD")
    val aud: Double,
    @SerializedName("CAD")
    val cad: Double,
    @SerializedName("MXN")
    val mxn: Double,
    @SerializedName("PLN")
    val pln: Double,
    @SerializedName("USD")
    val usd: Double,
    @SerializedName("EUR")
    val eur: Double
)