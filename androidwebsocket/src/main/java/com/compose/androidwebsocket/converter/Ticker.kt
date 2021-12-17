package com.compose.androidwebsocket.converter

import com.compose.androidwebsocket.dto.TickerDataDto
import com.compose.androidwebsocket.dto.TickerDataPairDto
import com.compose.androidwebsocket.dto.TickerDto
import com.compose.androidwebsocket.model.TickerDataModel
import com.compose.androidwebsocket.model.TickerDataPairModel
import com.compose.androidwebsocket.model.TickerModel

fun TickerDto.toModel() = TickerModel().also { tickerModel ->
    tickerModel.ch = ch
    tickerModel.tickerDataModel = tickerDataDtoToTickerDataModel(tickerDataDto)
}

fun tickerDataDtoToTickerDataModel(tickerDataDto: TickerDataDto): TickerDataModel {
    return TickerDataModel(ticketDataPairDtoToTickerDataPairModel(tickerDataDto.tickerDataPairDto))
}

fun ticketDataPairDtoToTickerDataPairModel(tickerDataPairDto: TickerDataPairDto): TickerDataPairModel {
    return TickerDataPairModel(
        tickerDataPairDto.timestampInMillis,
        tickerDataPairDto.bestAsk,
        tickerDataPairDto.bestAskQuantity,
        tickerDataPairDto.bestBid,
        tickerDataPairDto.bestBidQuantity,
        tickerDataPairDto.lastPrice,
        tickerDataPairDto.openPrice,
        tickerDataPairDto.highPrice,
        tickerDataPairDto.lowPrice,
        tickerDataPairDto.baseAssetVolume,
        tickerDataPairDto.quoteAssetVolume,
        tickerDataPairDto.priceChange,
        tickerDataPairDto.priceChangePercent,
        tickerDataPairDto.lastTradeIdentifier
    )
}

fun Array<String>.toTickerData() = TickerDto(
    ch =            this[0],
    tickerDataDto =               TickerDataDto(
        TickerDataPairDto(
            this[0].toInt(),
            this[1],
            this[2],
            this[3],
            this[4],
            this[5],
            this[6],
            this[7],
            this[8],
            this[9],
            this[10],
            this[8],
            this[9],
            this[10].toInt()
        )
    ),
)