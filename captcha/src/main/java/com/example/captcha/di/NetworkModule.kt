package com.example.captcha.di

import com.example.captcha.data.api.GeeTestApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.converter.gson.GsonConverterFactory


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

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