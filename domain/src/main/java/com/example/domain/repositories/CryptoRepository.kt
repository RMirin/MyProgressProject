package com.example.domain.repositories

import com.example.domain.entity.CryptoDataModel
import kotlinx.coroutines.flow.Flow

interface CryptoRepository {
    fun getCrypto(): Flow<List<CryptoDataModel>>
}