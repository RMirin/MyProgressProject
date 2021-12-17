package com.compose.androidwebsocket.usecases

import com.compose.androidwebsocket.dto.TickerDto
import com.compose.androidwebsocket.request.SubscribeTickerRequest
import com.compose.androidwebsocket.request.TickerRequestParams
import com.compose.androidwebsocket.repository.WebSocketRepository
import io.reactivex.Flowable

class WebSocketUseCase(private val webSocketRepository: WebSocketRepository) {

    operator fun invoke(): Flowable<TickerDto> {
        val subscribeTicker = SubscribeTickerRequest(
            method = "subscribe",
            ch = "ticker/1s",
            requestParams = TickerRequestParams(arrayListOf("ETHBTC", "BTCUSDT")),
            id = 123
        )
        return webSocketRepository.observeTicker(subscribeTicker)
    }
}