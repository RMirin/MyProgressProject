package com.example.data.local

import com.example.data.local.dao.CryptoDao
import com.example.data.local.entity.Crypto
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CryptoSource @Inject constructor(
    private val dao: CryptoDao
) {

    fun getCrypto(): Flow<List<Crypto>> = dao.getAllCrypto()
}