package com.example.domain.repositories

import com.example.data.local.entity.Professions_Db
import kotlinx.coroutines.flow.Flow

interface ProfessionsRepository {
    suspend fun insertInitialData(professionDataList: MutableList<Professions_Db>)
    fun getProfessions(): Flow<List<Professions_Db>>
}