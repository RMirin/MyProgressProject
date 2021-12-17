package com.compose.androidwebsocket.repository

import com.compose.androidwebsocket.converter.toTickerData
import com.compose.androidwebsocket.data.remote.HitBtcClientImpl
import com.compose.androidwebsocket.dto.TickerDto
import com.compose.androidwebsocket.request.SubscribeTickerRequest
import io.reactivex.Flowable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WebSocketRepositoryImpl @Inject constructor(
    private val hitBtcClientImpl: HitBtcClientImpl
) : WebSocketRepository {

    override fun observeTicker(subscribeTickerRequest: SubscribeTickerRequest): Flowable<TickerDto> {
        return hitBtcClientImpl.subscribeTicker(subscribeTickerRequest)
            .map {
                    response -> response.toTickerData()
            }
    }
}