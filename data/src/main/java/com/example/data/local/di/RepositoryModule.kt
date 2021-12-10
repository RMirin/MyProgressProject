package com.example.data.local.di

import com.evgfad.captcha.network.GeeTestApi
import com.example.data.local.repository.CaptchaRepositoryImpl
import com.example.domain.repositories.CaptchaRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    fun provideCaptchaRepository(geeTestApi: GeeTestApi): CaptchaRepository =
        CaptchaRepositoryImpl(geeTestApi)
}