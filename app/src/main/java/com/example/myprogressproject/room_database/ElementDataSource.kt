package com.example.myprogressproject.room_database

import com.example.myprogressproject.database.IElementOCurrentProfDataSource
import com.example.myprogressproject.model.ElementOfCurrentProf
import io.reactivex.Single

class ElementDataSource(private val elementDAO: ElementDao):
    IElementOCurrentProfDataSource {
    override val allElements: Single<MutableList<ElementOfCurrentProf>>
        get() = elementDAO.allElements

    override fun getElementById(id: Long): Single<ElementOfCurrentProf> {
        return elementDAO.getElementById(id)
    }

    override fun updateElement(vararg elements: ElementOfCurrentProf) {
        elementDAO.updateElement(*elements)
    }

    companion object {
        private var mInstance :ElementDataSource?=null
        fun getInstance(elementDAO: ElementDao) :ElementDataSource {
            if (mInstance == null) mInstance = ElementDataSource(elementDAO)
            return mInstance!!
        }
    }
}