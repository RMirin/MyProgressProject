package com.example.captcha.data.api

import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Query

interface GeeTestApi {

    @GET("register-slide")
    suspend fun registerSlide(@Query("t") t: Long): ResponseBody
}