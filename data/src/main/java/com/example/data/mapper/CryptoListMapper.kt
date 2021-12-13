package com.example.data.mapper

import com.example.data.local.entity.Crypto
import com.example.domain.entity.CryptoDataModel

fun Crypto.toModel() = CryptoDataModel().also {
    it.imageUrl = imageUrl
    it.name = name
    it.underName = undername
    it.currentPrice = currentPrice
    it.priceChange = priceChange
    it.totalPrice = totalPrice
    it.totalCount = totalCount
}

fun cryptoDataListToCryptoModelList(cryptoDataList: List<Crypto>): List<CryptoDataModel> {
    val cryptoModelList = mutableListOf<CryptoDataModel>()
    for (cryptoData in cryptoDataList) {
        cryptoModelList.add(cryptoData.toModel())
    }
    return cryptoModelList
}