package com.compose.androidwebsocket.dto

import com.google.gson.annotations.SerializedName

data class TickerDataDto(
    @SerializedName("ETHBTC") val tickerDataPairDto: TickerDataPairDto
)