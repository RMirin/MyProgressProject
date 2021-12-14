package com.compose.authcaptcha.di

import android.content.Context
import android.net.ConnectivityManager
import com.compose.authcaptcha.BuildConfig
import com.compose.authcaptcha.interceptor.NetworkConnectionInterceptor
import com.compose.authcaptcha.repository.AuthCaptchaRepository
import com.compose.authcaptcha.repository.AuthCaptchaRepositoryImpl
import com.compose.authcaptcha.service.ApiService
import com.compose.authcaptcha.service.NetworkService
import com.compose.authcaptcha.service.NetworkServiceImpl
import com.compose.authcaptcha.usecases.AuthCaptchaUseCase
import com.compose.authcaptcha.usecases.AuthCaptchaUseCaseImpl
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
                val trustManagers: Array<TrustManager> = trustManagerFactory.trustManagers
                check(!(trustManagers.size != 1 || trustManagers[0] !is X509TrustManager)) {
                    "Unexpected default trust managers:" + trustManagers.contentToString()
                }
            }
            .build()

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(BuildConfig.GEE_TEST_API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService =
        retrofit.create(ApiService::class.java)

    @Provides
    @Singleton
    fun provideAuthCaptchaRepository(apiService: ApiService): AuthCaptchaRepository =
        AuthCaptchaRepositoryImpl(apiService)

    @Provides
    @Singleton
    fun provideAuthCaptchaUseCase(authCaptchaRepository: AuthCaptchaRepository): AuthCaptchaUseCase =
        AuthCaptchaUseCaseImpl(authCaptchaRepository)
}