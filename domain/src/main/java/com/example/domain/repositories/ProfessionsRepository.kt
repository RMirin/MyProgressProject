package com.example.domain.repositories

import com.example.data.local.entity.Professions_Db
import kotlinx.coroutines.flow.Flow

interface ProfessionsRepository {
    fun getProfessions(): Flow<List<Professions_Db>>
}