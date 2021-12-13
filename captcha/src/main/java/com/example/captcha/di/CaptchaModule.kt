package com.example.captcha.di

import com.example.captcha.data.api.GeeTestApi
import com.example.captcha.data.repository.CaptchaRepositoryImpl
import com.example.captcha.domain.repository.CaptchaRepository
import com.example.captcha.domain.usecase.CaptchaUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
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
}