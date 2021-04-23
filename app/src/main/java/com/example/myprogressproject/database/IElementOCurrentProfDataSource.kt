package com.example.myprogressproject.database

import com.example.myprogressproject.model.ElementOfCurrentProf
import io.reactivex.Single

interface IElementOCurrentProfDataSource {
    val allElements: Single<MutableList<ElementOfCurrentProf>>
    fun getElementById(id: Long): Single<ElementOfCurrentProf>
    fun updateElement(vararg elements: ElementOfCurrentProf)
}