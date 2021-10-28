package com.example.domain.converters

//import androidx.room.TypeConverter
//import com.example.domain.entities.ProfessionModel
//import com.google.gson.Gson
//import com.google.gson.reflect.TypeToken
//
//class ProfessionConverters {
//
//    @TypeConverter
//    fun listToGsonProfession(list: List<ProfessionModel>): String = Gson().toJson(list)
//
//    @TypeConverter
//    fun gsonToListCreditMonths(str: String): List<ProfessionModel> {
//        val type = object : TypeToken<List<ProfessionModel>>() {}.type
//
//        return Gson().fromJson(str, type)
//    }
//}