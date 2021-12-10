package com.compose.authcaptcha.di

import android.content.Context
import android.net.ConnectivityManager
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
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AuthCaptchaModule {

    @Provides
    @Singleton
    fun provideAuthCaptchaRepository(apiService: ApiService): AuthCaptchaRepository =
        AuthCaptchaRepositoryImpl(apiService)

    @Provides
    @Singleton
    fun provideAuthCaptchaUseCase(authCaptchaRepository: AuthCaptchaRepository): AuthCaptchaUseCase =
        AuthCaptchaUseCaseImpl(authCaptchaRepository)

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
            .build()

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://api.geetest.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService =
        retrofit.create(ApiService::class.java)

//    @Provides
//    @Singleton
//    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
//        Retrofit.Builder()
//            .baseUrl("https://api.geetest.com/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .client(okHttpClient)
//            .build()
//
//    @Provides
//    @Singleton
//    fun provideApiService(retrofit: Retrofit): ApiService =
//        retrofit.create(ApiService::class.java)
}