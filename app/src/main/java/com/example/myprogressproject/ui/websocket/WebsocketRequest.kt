package com.example.myprogressproject.ui.websocket

import com.example.myprogressproject.ui.websocket.WebsocketRequestParams

data class WebsocketRequest(
    val method: String,
    val ch: String,
    val params: WebsocketRequestParams,
    val id: Int
)