package com.example.data.local

import com.example.data.local.dao.ProfessionDao
import com.example.data.local.entity.Professions_Db
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProfessionsSource @Inject constructor(
    private val dao: ProfessionDao
) {

    fun getProfessions(): Flow<List<Professions_Db>> = dao.getAllProfessions()
}