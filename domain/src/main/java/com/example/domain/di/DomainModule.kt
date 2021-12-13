package com.example.domain.di

import com.example.domain.repositories.CryptoRepository
import com.example.domain.usecases.CryptoUseCase
import com.example.domain.usecases.CryptoUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {

    @Provides
    @Singleton
    fun provideProfessionsUseCase(cryptoRepository: CryptoRepository): CryptoUseCase =
        CryptoUseCaseImpl(cryptoRepository)
}