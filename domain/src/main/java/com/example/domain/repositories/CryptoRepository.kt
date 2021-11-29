package com.example.domain.repositories

import com.example.data.local.entity.Crypto
import kotlinx.coroutines.flow.Flow

interface CryptoRepository {
    fun getCrypto(): Flow<List<Crypto>>
}