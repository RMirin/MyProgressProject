package com.compose.authcaptcha.service

import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("register-slide")
    suspend fun getCaptcha(
        @Query("t") time: Long,
    ): ResponseBody
}