package com.compose.androidwebsocket.data.remote

import com.compose.androidwebsocket.request.SubscribeTickerRequest
import io.reactivex.Flowable

interface HitBtcClient {

    fun subscribeTicker(subscribeTickerRequest: SubscribeTickerRequest): Flowable<Array<String>>
}