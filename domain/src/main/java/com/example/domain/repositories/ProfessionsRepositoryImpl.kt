package com.example.domain.repositories

import com.example.data.local.ProfessionsSource
import com.example.data.local.entity.ProfessionDataModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProfessionsRepositoryImpl @Inject constructor(private val source: ProfessionsSource) :
    ProfessionsRepository {

    override fun getProfessions(): Flow<List<ProfessionDataModel>> = source.getProfessions()
}