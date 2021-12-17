package com.compose.androidwebsocket.repository

import com.compose.androidwebsocket.dto.TickerDto
import com.compose.androidwebsocket.request.SubscribeTickerRequest
import io.reactivex.Flowable

interface WebSocketRepository {
    fun observeTicker(subscribeTickerRequest: SubscribeTickerRequest): Flowable<TickerDto>
}