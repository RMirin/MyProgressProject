package com.example.myprogressproject.room_database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.myprogressproject.model.ElementOfCurrentProf
import io.reactivex.Flowable

@Dao
interface ElementDao {

    @get:Query("SELECT * FROM elements")
    val allElements: Flowable<MutableList<ElementOfCurrentProf>>

    @Query("SELECT * FROM elements WHERE id=:elementId")
    fun getElementById(elementId: Long): Flowable<ElementOfCurrentProf>

    @Update
    fun updateElement(vararg element: ElementOfCurrentProf)

    @Insert
    fun insertData(data: MutableList<ElementOfCurrentProf>)
}