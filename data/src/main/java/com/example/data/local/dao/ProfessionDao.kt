package com.example.data.local.dao

import androidx.room.*
import com.example.data.local.entity.ProfessionDataModel
import kotlinx.coroutines.flow.Flow

@Dao
interface ProfessionDao {

    @Query("SELECT * FROM professions")
    fun getAllProfessions(): Flow<List<ProfessionDataModel>>

//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insertImage(image: ProfessionDataModel)
}