package com.example.data.local.dao

import androidx.room.*
import com.example.data.local.entity.Professions_Db
import kotlinx.coroutines.flow.Flow

@Dao
interface ProfessionDao {

    @Query("SELECT * FROM Professions_Db")
    fun getAllProfessions(): Flow<List<Professions_Db>>

//    @Insert
//    fun insertData(data: MutableList<Professions_Db>)

//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insertImage(image: ProfessionDataModel)
}