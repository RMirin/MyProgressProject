package com.example.domain.usecases

import com.example.domain.entity.CryptoDataModel
import com.example.domain.repositories.CryptoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import com.example.domain.mapper.cryptoDataListToCryptoModelList
import javax.inject.Inject
import javax.inject.Singleton

interface CryptoUseCase {
    suspend fun getData(): Flow<List<CryptoDataModel>>
}

@Singleton
class CryptoUseCaseImpl @Inject constructor(
    private val cryptoRepository: CryptoRepository
) : CryptoUseCase {

    override suspend fun getData(): Flow<List<CryptoDataModel>> {
        return cryptoRepository.getCrypto().map {
                list ->
            cryptoDataListToCryptoModelList(list)
        }
    }
}