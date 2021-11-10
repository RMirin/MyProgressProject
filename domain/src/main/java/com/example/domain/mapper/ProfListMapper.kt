package com.example.domain.mapper

import com.example.data.local.entity.Professions_Db
import com.example.domain.entity.ProfDataModel

fun Professions_Db.toModel() = ProfDataModel().also {
    it.imageUrl = imageUrl
    it.name = name
    it.progressCurrent = progressCurrent
    it.progressTotal = progressTotal
}

fun professionDataListToProfessionModelList(professionDataList: List<Professions_Db>): List<ProfDataModel> {
    val profModelList = mutableListOf<ProfDataModel>()
    for (professionData in professionDataList) {
        profModelList.add(professionData.toModel())
    }
    return profModelList
}