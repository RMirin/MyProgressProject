package com.example.domain.usecases

import android.util.Log
import com.example.domain.entity.ProfDataModel
import com.example.domain.repositories.ProfessionsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import com.example.domain.mapper.professionDataListToProfessionModelList
import javax.inject.Inject
import javax.inject.Singleton

interface ProfessionsUseCase {
    suspend fun getData(): Flow<List<ProfDataModel>>
}

@Singleton
class ProfessionsUseCaseImpl @Inject constructor(
    val professionsRepository: ProfessionsRepository
) : ProfessionsUseCase {
//    private suspend fun insertInitialData() {
//        val professionDataList = mutableListOf<ProfessionData>()
//        professionDataList.add(
//            ProfessionData(
//                "Blacksmithing",
//                "1111",
//                300,
//                0
//            )
//        )
//        professionDataList.add(
//            ProfessionData(
//                "Enchanting",
//                "1111",
//                300,
//                0
//            )
//        )
//        professionDataList.add(
//            ProfessionData(
//                "Tailoring",
//                "1111",
//                300,
//                0
//            )
//        )
//        professionDataList.add(
//            ProfessionData(
//                "Jewelcrafting",
//                "1111",
//                300,
//                0
//            )
//        )
//        professionDataList.add(
//            ProfessionData(
//                "Leatherworking",
//                "1111",
//                300,
//                0
//            )
//        )
//        professionDataList.add(
//            ProfessionData(
//                "Engineering",
//                "1111",
//                300,
//                0
//            )
//        )
//        professionDataList.add(
//            ProfessionData(
//                "First Aid",
//                "1111",
//                300,
//                0
//            )
//        )
//        professionDataList.add(
//            ProfessionData(
//                "Cooking",
//                "1111",
//                300,
//                0
//            )
//        )
//        professionsRepository.insertInitialData(professionDataList)
//    }

    override suspend fun getData(): Flow<List<ProfDataModel>> {
        return professionsRepository.getProfessions().map {
                list ->
            if (list.isEmpty()) {
                Log.e("TAG", "getData: ", )
            }
            professionDataListToProfessionModelList(list)
        }
    }
}