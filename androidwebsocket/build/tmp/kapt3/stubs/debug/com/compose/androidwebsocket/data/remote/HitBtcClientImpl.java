package com.compose.androidwebsocket.data.remote;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/compose/androidwebsocket/data/remote/HitBtcClientImpl;", "Lcom/compose/androidwebsocket/data/remote/HitBtcClient;", "hitBtcApi", "Lcom/compose/androidwebsocket/data/remote/HitBtcApi;", "(Lcom/compose/androidwebsocket/data/remote/HitBtcApi;)V", "subscribeTicker", "Lio/reactivex/Flowable;", "Lcom/compose/androidwebsocket/dto/TickerDto;", "subscribeTickerRequest", "Lcom/compose/androidwebsocket/request/SubscribeTickerRequest;", "androidwebsocket_debug"})
@javax.inject.Singleton()
public final class HitBtcClientImpl implements com.compose.androidwebsocket.data.remote.HitBtcClient {
    private final com.compose.androidwebsocket.data.remote.HitBtcApi hitBtcApi = null;
    
    public HitBtcClientImpl(@org.jetbrains.annotations.NotNull()
    com.compose.androidwebsocket.data.remote.HitBtcApi hitBtcApi) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Flowable<com.compose.androidwebsocket.dto.TickerDto> subscribeTicker(@org.jetbrains.annotations.NotNull()
    com.compose.androidwebsocket.request.SubscribeTickerRequest subscribeTickerRequest) {
        return null;
    }
}