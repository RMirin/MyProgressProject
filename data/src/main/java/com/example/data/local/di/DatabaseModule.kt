package com.example.data.local.di

import android.content.Context
import androidx.room.Room
import com.example.data.local.CryptoSource
import com.example.data.local.dao.CryptoDao
import com.example.data.local.db.DatabaseManager
import com.example.data.local.repository.CryptoRepositoryImpl
import com.example.domain.repositories.CryptoRepository
import com.example.domain.usecases.CryptoUseCase
import com.example.domain.usecases.CryptoUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideCryptoSource(dao: CryptoDao): CryptoSource =
        CryptoSource(dao)

    @Provides
    @Singleton
    fun provideCryptoRepository(localSource: CryptoSource): CryptoRepository =
        CryptoRepositoryImpl(localSource)

    @Provides
    @Singleton
    fun provideCryptoUseCase(cryptoRepository: CryptoRepository): CryptoUseCase =
        CryptoUseCaseImpl(cryptoRepository)

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): DatabaseManager =
        Room.databaseBuilder(
            context,
            DatabaseManager::class.java,
            "crypto"
        ).createFromAsset("database/crypto.db").build()

    @Provides
    @Singleton
    fun provideCryptoDao(db: DatabaseManager): CryptoDao = db.getCryptoDao()
}