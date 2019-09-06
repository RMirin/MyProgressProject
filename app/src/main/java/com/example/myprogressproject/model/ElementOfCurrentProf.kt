package com.example.myprogressproject.model

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * класс данных для хранения в базе данных конкретного элемента профессии
 */
@Entity(tableName = "elements")
data class ElementOfCurrentProf(
    @ColumnInfo(name = "name") var name: String? = null,

    @ColumnInfo(name = "image_url") var imageUrl: String? = null,

    @ColumnInfo(name = "progress_total") var progressTotal: Int = 0,

    @ColumnInfo(name = "progress_current") var progressCurrent: Int = 0
) {
    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long = 0
}