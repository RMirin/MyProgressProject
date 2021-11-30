package com.example.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.local.dao.CryptoDao
import com.example.data.local.entity.Crypto

@Database(entities = [Crypto::class], version = 1)
abstract class DatabaseManager : RoomDatabase() {
    abstract fun getCryptoDao(): CryptoDao
}