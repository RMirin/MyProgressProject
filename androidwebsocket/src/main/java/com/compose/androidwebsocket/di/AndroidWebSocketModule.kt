package com.compose.androidwebsocket.di

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import com.compose.androidwebsocket.data.remote.HitBtcApi
import com.compose.androidwebsocket.data.remote.HitBtcClientImpl
import com.compose.androidwebsocket.repository.WebSocketRepository
import com.compose.androidwebsocket.repository.WebSocketRepositoryImpl
import com.compose.androidwebsocket.service.NetworkService
import com.compose.androidwebsocket.service.NetworkServiceImpl
import com.compose.androidwebsocket.usecases.WebSocketUseCase
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.tinder.scarlet.Lifecycle
import com.tinder.scarlet.Scarlet
import com.tinder.scarlet.lifecycle.android.AndroidLifecycle
import com.tinder.scarlet.messageadapter.moshi.MoshiMessageAdapter
import com.tinder.scarlet.streamadapter.rxjava2.RxJava2StreamAdapterFactory
import com.tinder.scarlet.websocket.okhttp.newWebSocketFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AndroidWebSocketModule {

    @Provides
    @Singleton
    fun provideNetworkService(@ApplicationContext context: Context): NetworkService =
        NetworkServiceImpl(
            context.getSystemService(
                Context.CONNECTIVITY_SERVICE
            ) as ConnectivityManager
        )

    @Provides
    @Singleton
    fun provideApplication(@ApplicationContext context: Context): Application = context as Application

    @Provides
    @Singleton
    fun provideAndroidLifecycle(application: Application): Lifecycle {
        return AndroidLifecycle.ofApplicationForeground(application)
    }

    @Provides
    @Singleton
    fun provideScarlet(okHttpClient: OkHttpClient, lifecycle: Lifecycle): HitBtcApi = Scarlet.Builder()
            .webSocketFactory(okHttpClient.newWebSocketFactory(HitBtcApi.BASE_URI))
            .lifecycle(lifecycle)
            .addMessageAdapterFactory(MoshiMessageAdapter.Factory(jsonMoshi))
            .addStreamAdapterFactory(RxJava2StreamAdapterFactory())
            .build()
            .create()

    private val jsonMoshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    @Provides
    @Singleton
    fun provideHitBtcClientImpl(hitBtcApi: HitBtcApi): HitBtcClientImpl = HitBtcClientImpl(hitBtcApi)

    @Provides
    @Singleton
    fun provideWebSocketRepository(hitBtcClientImpl: HitBtcClientImpl): WebSocketRepository =
        WebSocketRepositoryImpl(hitBtcClientImpl)

    @Provides
    @Singleton
    fun provideWebSocketUseCase(webSocketRepositoryImpl: WebSocketRepositoryImpl): WebSocketUseCase =
        WebSocketUseCase(webSocketRepositoryImpl)
}