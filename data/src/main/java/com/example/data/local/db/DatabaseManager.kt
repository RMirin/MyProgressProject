package com.example.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.local.dao.ProfessionDao
import com.example.data.local.entity.Professions_Db

@Database(entities = [Professions_Db::class], version = 1)
abstract class DatabaseManager : RoomDatabase() {
    abstract fun getProfessionDao(): ProfessionDao
}