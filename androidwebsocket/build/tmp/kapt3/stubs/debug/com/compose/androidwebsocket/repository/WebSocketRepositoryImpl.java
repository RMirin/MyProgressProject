package com.compose.androidwebsocket.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/compose/androidwebsocket/repository/WebSocketRepositoryImpl;", "Lcom/compose/androidwebsocket/repository/WebSocketRepository;", "hitBtcClientImpl", "Lcom/compose/androidwebsocket/data/remote/HitBtcClientImpl;", "(Lcom/compose/androidwebsocket/data/remote/HitBtcClientImpl;)V", "observeTicker", "Lio/reactivex/Flowable;", "Lcom/compose/androidwebsocket/dto/TickerDto;", "subscribeTickerRequest", "Lcom/compose/androidwebsocket/request/SubscribeTickerRequest;", "androidwebsocket_debug"})
@javax.inject.Singleton()
public final class WebSocketRepositoryImpl implements com.compose.androidwebsocket.repository.WebSocketRepository {
    private final com.compose.androidwebsocket.data.remote.HitBtcClientImpl hitBtcClientImpl = null;
    
    @javax.inject.Inject()
    public WebSocketRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.compose.androidwebsocket.data.remote.HitBtcClientImpl hitBtcClientImpl) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Flowable<com.compose.androidwebsocket.dto.TickerDto> observeTicker(@org.jetbrains.annotations.NotNull()
    com.compose.androidwebsocket.request.SubscribeTickerRequest subscribeTickerRequest) {
        return null;
    }
}