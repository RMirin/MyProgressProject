package com.example.data.local.di

import android.content.Context
import androidx.room.Room
import com.example.data.local.dao.ProfessionDao
import com.example.data.local.db.DatabaseManager

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
    fun provideDatabase(@ApplicationContext context: Context): DatabaseManager =
        Room.databaseBuilder(
            context,
            DatabaseManager::class.java,
            "professions_db"
        ).createFromAsset("database/prof_data.db").build()

    @Provides
    @Singleton
    fun provideCryptoDao(db: DatabaseManager): ProfessionDao = db.getProfessionDao()
}