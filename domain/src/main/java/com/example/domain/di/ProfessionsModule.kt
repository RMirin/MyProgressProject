package com.example.domain.di

import com.example.data.local.ProfessionsSource
import com.example.data.local.dao.ProfessionDao
import com.example.domain.repositories.ProfessionsRepository
import com.example.domain.repositories.ProfessionsRepositoryImpl
import com.example.domain.usecases.ProfessionsUseCase
import com.example.domain.usecases.ProfessionsUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ProfessionsModule {

    @Provides
    @Singleton
    fun provideProfessionsSource(dao: ProfessionDao): ProfessionsSource =
        ProfessionsSource(dao)

    @Provides
    @Singleton
    fun provideProfessionsRepository(localSource: ProfessionsSource): ProfessionsRepository =
        ProfessionsRepositoryImpl(localSource)

    @Provides
    @Singleton
    fun provideProfessionsUseCase(professionsRepository: ProfessionsRepository): ProfessionsUseCase =
        ProfessionsUseCaseImpl(professionsRepository)
}