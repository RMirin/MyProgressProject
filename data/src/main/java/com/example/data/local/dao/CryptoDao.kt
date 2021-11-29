package com.example.data.local.dao

import androidx.room.*
import com.example.data.local.entity.Crypto
import kotlinx.coroutines.flow.Flow

@Dao
interface CryptoDao {

    @Query("SELECT * FROM Crypto")
    fun getAllCrypto(): Flow<List<Crypto>>

//    @Insert
//    fun insertData(data: MutableList<Professions_Db>)

//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insertImage(image: ProfessionDataModel)
}