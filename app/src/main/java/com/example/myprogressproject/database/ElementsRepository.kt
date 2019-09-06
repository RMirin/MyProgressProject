package com.example.myprogressproject.database

import com.example.myprogressproject.model.ElementOfCurrentProf
import io.reactivex.Flowable

class ElementsRepository(private val mElementOfCurrentProfDataSource: IElementOCurrentProfDataSource):
    IElementOCurrentProfDataSource {
    override val allElements: Flowable<MutableList<ElementOfCurrentProf>>
        get() = mElementOfCurrentProfDataSource.allElements

    override fun getElementById(id: Long): Flowable<ElementOfCurrentProf> {
        return mElementOfCurrentProfDataSource.getElementById(id)
    }

    override fun updateElement(vararg elements: ElementOfCurrentProf) {
        mElementOfCurrentProfDataSource.updateElement(*elements)
    }

    companion object {
        private var mInstance :ElementsRepository?=null
        fun getInstance(mElementOfCurrentProfDataSource: IElementOCurrentProfDataSource) :ElementsRepository {
            if (mInstance == null) mInstance = ElementsRepository(mElementOfCurrentProfDataSource)
            return mInstance!!
        }
    }
}