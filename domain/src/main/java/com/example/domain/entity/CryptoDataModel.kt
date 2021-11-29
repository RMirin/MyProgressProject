package com.example.domain.entity

import androidx.annotation.NonNull

data class CryptoDataModel(
   var imageUrl: String = "",
   var name: String = "",
   var underName: String = "",
   var currentPrice: Int = 0,
   var priceChange: Int = 0,
   var totalPrice: Int = 0,
   var totalCount: Int = 0
)