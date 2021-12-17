package com.compose.androidwebsocket.request

data class SubscribeTickerRequest(
    val method: String,
    val ch: String,
    val requestParams: TickerRequestParams,
    val id: Int
)