package com.example.myprogressproject.di

import com.compose.authcaptcha.repository.AuthCaptchaRepositoryImpl
import com.compose.authcaptcha.service.ApiService
import com.example.domain.repositories.AuthCaptchaRepository
import com.example.domain.usecases.AuthCaptchaUseCase
import com.example.domain.usecases.AuthCaptchaUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class CryptoListModule {

    @Provides
    @Singleton
    fun provideAuthCaptchaRepository(apiService: ApiService): AuthCaptchaRepository =
        AuthCaptchaRepositoryImpl(apiService)

    @Provides
    @Singleton
    fun provideAuthCaptchaUseCase(authCaptchaRepository: AuthCaptchaRepository): AuthCaptchaUseCase =
        AuthCaptchaUseCaseImpl(authCaptchaRepository)
}