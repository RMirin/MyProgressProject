package com.example.domain.repositories

import com.example.data.local.entity.ProfessionDataModel
import kotlinx.coroutines.flow.Flow

interface ProfessionsRepository {
    fun getProfessions(): Flow<List<ProfessionDataModel>>
}