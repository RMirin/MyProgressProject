package com.example.domain.di

import com.example.data.local.CryptoSource
import com.example.data.local.dao.CryptoDao
import com.example.domain.repositories.CryptoRepository
import com.example.domain.repositories.CryptoRepositoryImpl
import com.example.domain.usecases.CryptoUseCase
import com.example.domain.usecases.CryptoUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class CryptoModule {

    @Provides
    @Singleton
    fun provideProfessionsSource(dao: CryptoDao): CryptoSource =
        CryptoSource(dao)

    @Provides
    @Singleton
    fun provideProfessionsRepository(localSource: CryptoSource): CryptoRepository =
        CryptoRepositoryImpl(localSource)

    @Provides
    @Singleton
    fun provideProfessionsUseCase(cryptoRepository: CryptoRepository): CryptoUseCase =
        CryptoUseCaseImpl(cryptoRepository)
}