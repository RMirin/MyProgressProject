package com.example.myprogressproject.database

import com.example.myprogressproject.model.ElementOfCurrentProf
import io.reactivex.Flowable

interface IElementOCurrentProfDataSource {
    val allElements:Flowable<MutableList<ElementOfCurrentProf>>
    fun getElementById(id: Long): Flowable<ElementOfCurrentProf>
    fun updateElement(vararg elements: ElementOfCurrentProf)
}