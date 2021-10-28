package com.example.data.local

import com.example.data.local.dao.ProfessionDao
import com.example.data.local.entity.ProfessionDataModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProfessionsSource @Inject constructor(
    private val dao: ProfessionDao
) {

    fun getProfessions(): Flow<List<ProfessionDataModel>> = dao.getAllProfessions()
}