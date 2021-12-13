package com.example.captcha.di

import com.example.captcha.data.api.GeeTestApi
import com.example.captcha.data.repository.CaptchaRepositoryImpl
import com.example.captcha.domain.repository.CaptchaRepository
import com.example.captcha.domain.usecase.CaptchaUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CaptchaModule {

    @Provides
    @Singleton
    fun provideCaptchaRepository(geeTestApi: GeeTestApi): CaptchaRepository =
        CaptchaRepositoryImpl(geeTestApi)

    @Provides
    @Singleton
    fun provideCaptchaUseCase(captchaRepository: CaptchaRepository): CaptchaUseCase =
        CaptchaUseCase(captchaRepository)

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .build()

    @Singleton
    @Provides
    fun provideGeeTestApi(client: OkHttpClient): GeeTestApi = Retrofit.Builder()
        .baseUrl("https://www.geetest.com/demo/gt/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()
        .create(GeeTestApi::class.java)
}