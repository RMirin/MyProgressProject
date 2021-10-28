package com.example.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.local.dao.ProfessionDao
import com.example.data.local.entity.ProfessionDataModel

@Database(entities = [ProfessionDataModel::class], version = 1, exportSchema = false)
abstract class DatabaseManager : RoomDatabase() {
    abstract fun getProfessionDao(): ProfessionDao
}