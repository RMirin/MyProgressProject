package com.compose.androidwebsocket.data.remote

import com.compose.androidwebsocket.request.SubscribeTickerRequest
import com.tinder.scarlet.WebSocket
import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers
import javax.inject.Singleton

@Singleton
class HitBtcClientImpl(private val hitBtcApi: HitBtcApi) : HitBtcClient {

    private val TICKER_SNAPSHOT_SIZE = 10

    override fun subscribeTicker(subscribeTickerRequest: SubscribeTickerRequest): Flowable<Array<String>> {
        hitBtcApi.openWebSocketEvent()
            .filter {
                it is WebSocket.Event.OnConnectionOpened<*>
            }
            .subscribe({
                hitBtcApi.sendTickerRequest(subscribeTickerRequest)
            }, { e ->
                e.printStackTrace()
//                Timber.e(e)
            })

        return hitBtcApi.observeTicker()
            .subscribeOn(Schedulers.io())
            .filter { it.size == TICKER_SNAPSHOT_SIZE } // make sure it's a ticker
    }
}