package com.example.domain.repositories

import com.example.data.local.CryptoSource
import com.example.data.local.entity.Crypto
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CryptoRepositoryImpl @Inject constructor(private val source: CryptoSource) :
    CryptoRepository {

    override fun getCrypto(): Flow<List<Crypto>> = source.getCrypto()
}