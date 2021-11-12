package com.example.domain.usecases

import com.example.domain.entity.ProfDataModel
import com.example.domain.repositories.ProfessionsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import com.example.domain.mapper.professionDataListToProfessionModelList
import javax.inject.Inject
import javax.inject.Singleton

interface ProfessionsUseCase {
    suspend fun getData(): Flow<List<ProfDataModel>>
}

@Singleton
class ProfessionsUseCaseImpl @Inject constructor(
    private val professionsRepository: ProfessionsRepository
) : ProfessionsUseCase {

    override suspend fun getData(): Flow<List<ProfDataModel>> {
        return professionsRepository.getProfessions().map {
                list ->
            professionDataListToProfessionModelList(list)
        }
    }
}