package com.compose.authcaptcha.di

import android.content.Context
import android.net.ConnectivityManager
import com.compose.authcaptcha.di.NetRequestUtils.PersistenceCookieJar
import com.example.core.interceptor.NetworkConnectionInterceptor
import com.compose.authcaptcha.repository.AuthCaptchaRepositoryImpl
import com.compose.authcaptcha.service.ApiService
import com.example.core.service.NetworkService
import com.example.core.service.NetworkServiceImpl
import com.example.domain.repositories.AuthCaptchaRepository
import com.example.domain.usecases.AuthCaptchaUseCase
import com.example.domain.usecases.AuthCaptchaUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.security.KeyStore
import java.security.SecureRandom
import java.util.*
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import javax.net.ssl.*

@Module
@InstallIn(SingletonComponent::class)
object AuthCaptchaModule {

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
    fun provideOkHttpClient(networkService: NetworkService): OkHttpClient =
        OkHttpClient.Builder()
            .readTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .addInterceptor(
                HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
            )
            .addInterceptor(NetworkConnectionInterceptor(networkService))
            .also {
                val trustManagerFactory: TrustManagerFactory =
                    TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm())
                trustManagerFactory.init(null as KeyStore?)
                val trustManagers: Array<TrustManager> = trustManagerFactory.getTrustManagers()
                check(!(trustManagers.size != 1 || trustManagers[0] !is X509TrustManager)) {
                    "Unexpected default trust managers:" + Arrays.toString(
                        trustManagers
                    )
                }
                val trustManager: X509TrustManager = trustManagers[0] as X509TrustManager
                val sslContext: SSLContext = SSLContext.getInstance("SSL")
                sslContext.init(null, arrayOf(NetRequestUtils.MyX509TrustManager()), SecureRandom())
                val sslSocketFactory: SSLSocketFactory = sslContext.getSocketFactory()
                it.cookieJar(PersistenceCookieJar())
                it.sslSocketFactory(sslSocketFactory, trustManager)
                it.followRedirects(true)
                it.followSslRedirects(true)
            }
            .build()

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://www.geetest.com/demo/gt/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService =
        retrofit.create(ApiService::class.java)
}