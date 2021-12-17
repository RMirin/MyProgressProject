package com.compose.androidwebsocket.model

data class TickerDataPairModel(
    var timestampInMillis: Int,
    var bestAsk: String,
    var bestAskQuantity: String,
    var bestBid: String,
    var bestBidQuantity: String,
    var lastPrice: String,
    var openPrice: String,
    var highPrice: String,
    var lowPrice: String,
    var baseAssetVolume: String,
    var quoteAssetVolume: String,
    var priceChange: String,
    var priceChangePercent: String,
    var lastTradeIdentifier: Int
)