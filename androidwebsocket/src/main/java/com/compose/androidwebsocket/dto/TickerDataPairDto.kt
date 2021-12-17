package com.compose.androidwebsocket.dto

import com.google.gson.annotations.SerializedName

data class TickerDataPairDto(
    @SerializedName("t") val timestampInMillis: Int,
    @SerializedName("a") val bestAsk: String,
    @SerializedName("A") val bestAskQuantity: String,
    @SerializedName("b") val bestBid: String,
    @SerializedName("B") val bestBidQuantity: String,
    @SerializedName("o") val lastPrice: String,
    @SerializedName("c") val openPrice: String,
    @SerializedName("h") val highPrice: String,
    @SerializedName("l") val lowPrice: String,
    @SerializedName("v") val baseAssetVolume: String,
    @SerializedName("q") val quoteAssetVolume: String,
    @SerializedName("p") val priceChange: String,
    @SerializedName("P") val priceChangePercent: String,
    @SerializedName("L") val lastTradeIdentifier: Int
)