package com.compose.androidwebsocket.data.remote

import com.compose.androidwebsocket.dto.TickerDto
import com.compose.androidwebsocket.request.SubscribeTickerRequest
import com.tinder.scarlet.WebSocket
import com.tinder.scarlet.ws.Receive
import com.tinder.scarlet.ws.Send
import io.reactivex.Flowable

interface HitBtcApi {

    @Receive
    fun openWebSocketEvent(): Flowable<WebSocket.Event>

    @Receive
    fun receiveResponse(): Flowable<TickerDto>

    @Send
    fun sendTickerRequest(subscribeTickerRequest: SubscribeTickerRequest)

    @Receive
    fun observeTicker(): Flowable<Array<String>>

    companion object {
        const val BASE_URI = "wss://api.demo.hitbtc.com/api/3/ws/public"
    }
}