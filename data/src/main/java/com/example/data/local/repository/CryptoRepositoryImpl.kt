package com.example.data.local.repository

import com.example.data.local.CryptoSource
import com.example.data.local.entity.Crypto
import com.example.data.mapper.cryptoDataListToCryptoModelList
import com.example.domain.entity.CryptoDataModel
import com.example.domain.repositories.CryptoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CryptoRepositoryImpl @Inject constructor(private val source: CryptoSource) :
    CryptoRepository {

    override fun getCrypto(): Flow<List<CryptoDataModel>> = source.getCrypto().map {
            list ->
        cryptoDataListToCryptoModelList(list)
    }
}