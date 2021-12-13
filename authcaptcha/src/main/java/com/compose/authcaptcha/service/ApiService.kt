package com.compose.authcaptcha.service

import com.compose.authcaptcha.response.GeeTestResponse
import okhttp3.Response
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("register-slide")
    suspend fun getCaptcha(
        @Query("t") time: Int,
    ): ResponseBody
}