package com.compose.authcaptcha.service

import com.compose.authcaptcha.response.GeeTestResponse
import retrofit2.http.GET

interface ApiService {

    @GET("")
    suspend fun getCaptcha(): GeeTestResponse
}