package com.example.data.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Professions_Db(
    @PrimaryKey val id: Int,
    @NonNull @ColumnInfo(name = "name") var name: String,
    @NonNull @ColumnInfo(name = "image_url") var imageUrl: String,
    @NonNull @ColumnInfo(name = "progress_total") var progressTotal: Int,
    @NonNull @ColumnInfo(name = "progress_current") var progressCurrent: Int
)