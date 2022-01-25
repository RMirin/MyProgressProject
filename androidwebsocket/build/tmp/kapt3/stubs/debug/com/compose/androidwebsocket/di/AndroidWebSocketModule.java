package com.compose.androidwebsocket.di;

import java.lang.System;

@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0012\u0010\u000e\u001a\u00020\u000f2\b\b\u0001\u0010\u0010\u001a\u00020\u0011H\u0007J\u0018\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000bH\u0007J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0007H\u0007J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0007R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/compose/androidwebsocket/di/AndroidWebSocketModule;", "", "()V", "jsonMoshi", "Lcom/squareup/moshi/Moshi;", "kotlin.jvm.PlatformType", "provideHitBtcClientImpl", "Lcom/compose/androidwebsocket/data/remote/HitBtcClientImpl;", "hitBtcApi", "Lcom/compose/androidwebsocket/data/remote/HitBtcApi;", "provideLifecycle", "Lcom/tinder/scarlet/Lifecycle;", "application", "Landroid/app/Application;", "provideNetworkService", "Lcom/compose/androidwebsocket/service/NetworkService;", "context", "Landroid/content/Context;", "provideScarlet", "okHttpClient", "Lokhttp3/OkHttpClient;", "lifecycle", "provideWebSocketRepository", "Lcom/compose/androidwebsocket/repository/WebSocketRepository;", "hitBtcClientImpl", "provideWebSocketUseCase", "Lcom/compose/androidwebsocket/usecases/WebSocketUseCase;", "webSocketRepositoryImpl", "Lcom/compose/androidwebsocket/repository/WebSocketRepositoryImpl;", "androidwebsocket_debug"})
@dagger.Module()
public final class AndroidWebSocketModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.compose.androidwebsocket.di.AndroidWebSocketModule INSTANCE = null;
    private static final com.squareup.moshi.Moshi jsonMoshi = null;
    
    private AndroidWebSocketModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.tinder.scarlet.Lifecycle provideLifecycle(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.compose.androidwebsocket.service.NetworkService provideNetworkService(@org.jetbrains.annotations.NotNull()
    @dagger.hilt.android.qualifiers.ApplicationContext()
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.compose.androidwebsocket.data.remote.HitBtcApi provideScarlet(@org.jetbrains.annotations.NotNull()
    okhttp3.OkHttpClient okHttpClient, @org.jetbrains.annotations.NotNull()
    com.tinder.scarlet.Lifecycle lifecycle) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.compose.androidwebsocket.data.remote.HitBtcClientImpl provideHitBtcClientImpl(@org.jetbrains.annotations.NotNull()
    com.compose.androidwebsocket.data.remote.HitBtcApi hitBtcApi) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.compose.androidwebsocket.repository.WebSocketRepository provideWebSocketRepository(@org.jetbrains.annotations.NotNull()
    com.compose.androidwebsocket.data.remote.HitBtcClientImpl hitBtcClientImpl) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.compose.androidwebsocket.usecases.WebSocketUseCase provideWebSocketUseCase(@org.jetbrains.annotations.NotNull()
    com.compose.androidwebsocket.repository.WebSocketRepositoryImpl webSocketRepositoryImpl) {
        return null;
    }
}