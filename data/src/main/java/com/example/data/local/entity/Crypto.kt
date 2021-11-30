package com.example.data.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Crypto(
    @PrimaryKey val id: Int,
    @NonNull @ColumnInfo(name = "image_url") var imageUrl: String,
    @NonNull @ColumnInfo(name = "name") var name: String,
    @NonNull @ColumnInfo(name = "undername") var undername: String,
    @NonNull @ColumnInfo(name = "current_price") var currentPrice: Int,
    @NonNull @ColumnInfo(name = "price_change_in_percent") var priceChange: Int,
    @NonNull @ColumnInfo(name = "total_price_in_usd") var totalPrice: Int,
    @NonNull @ColumnInfo(name = "total_count") var totalCount: Int
)