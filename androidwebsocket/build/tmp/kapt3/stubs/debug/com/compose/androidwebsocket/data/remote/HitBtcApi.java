package com.compose.androidwebsocket.data.remote;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \f2\u00020\u0001:\u0001\fJ\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\'J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003H\'J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\'J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\'\u00a8\u0006\r"}, d2 = {"Lcom/compose/androidwebsocket/data/remote/HitBtcApi;", "", "observeTicker", "Lio/reactivex/Flowable;", "Lcom/compose/androidwebsocket/dto/TickerDto;", "openWebSocketEvent", "Lcom/tinder/scarlet/WebSocket$Event;", "receiveResponse", "sendTickerRequest", "", "subscribeTickerRequest", "Lcom/compose/androidwebsocket/request/SubscribeTickerRequest;", "Companion", "androidwebsocket_debug"})
public abstract interface HitBtcApi {
    @org.jetbrains.annotations.NotNull()
    public static final com.compose.androidwebsocket.data.remote.HitBtcApi.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BASE_URI = "wss://api.multiexchange.com/api/3/ws/public";
    
    @org.jetbrains.annotations.NotNull()
    @com.tinder.scarlet.ws.Receive()
    public abstract io.reactivex.Flowable<com.tinder.scarlet.WebSocket.Event> openWebSocketEvent();
    
    @org.jetbrains.annotations.NotNull()
    @com.tinder.scarlet.ws.Receive()
    public abstract io.reactivex.Flowable<com.compose.androidwebsocket.dto.TickerDto> receiveResponse();
    
    @com.tinder.scarlet.ws.Send()
    public abstract void sendTickerRequest(@org.jetbrains.annotations.NotNull()
    com.compose.androidwebsocket.request.SubscribeTickerRequest subscribeTickerRequest);
    
    @org.jetbrains.annotations.NotNull()
    @com.tinder.scarlet.ws.Receive()
    public abstract io.reactivex.Flowable<com.compose.androidwebsocket.dto.TickerDto> observeTicker();
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/compose/androidwebsocket/data/remote/HitBtcApi$Companion;", "", "()V", "BASE_URI", "", "androidwebsocket_debug"})
    public static final class Companion {
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String BASE_URI = "wss://api.multiexchange.com/api/3/ws/public";
        
        private Companion() {
            super();
        }
    }
}