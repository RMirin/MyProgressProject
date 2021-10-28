package com.example.data.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "professions")
data class ProfessionDataModel(
    @ColumnInfo(name = "name") var name: String,

    @ColumnInfo(name = "image_url") var imageUrl: String,

    @ColumnInfo(name = "progress_total") var progressTotal: Int,

    @ColumnInfo(name = "progress_current") var progressCurrent: Int
) {
    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long? = null
}