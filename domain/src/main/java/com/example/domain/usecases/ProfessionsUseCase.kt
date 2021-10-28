package com.example.domain.usecases

import com.example.data.local.entity.ProfessionDataModel
import com.example.domain.repositories.ProfessionsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

interface ProfessionsUseCase {
    fun getData(): Flow<List<ProfessionDataModel>>
}

@Singleton
class ProfessionsUseCaseImpl @Inject constructor(
    val professionsRepository: ProfessionsRepository
) : ProfessionsUseCase {
    override fun getData(): Flow<List<ProfessionDataModel>> = professionsRepository.getProfessions()
}