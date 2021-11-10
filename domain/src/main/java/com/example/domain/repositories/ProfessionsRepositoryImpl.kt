package com.example.domain.repositories

import com.example.data.local.ProfessionsSource
import com.example.data.local.entity.Professions_Db
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProfessionsRepositoryImpl @Inject constructor(private val source: ProfessionsSource) :
    ProfessionsRepository {
    override suspend fun insertInitialData(professionDataList: MutableList<Professions_Db>) {
        source.insertProfessions(professionDataList)
    }

    override fun getProfessions(): Flow<List<Professions_Db>> = source.getProfessions()
}