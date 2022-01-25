package com.example.recaptcha.service

import com.example.recaptcha.response.RecaptchaVerifyResponse
import retrofit2.Response
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.QueryMap

interface ReCaptchaVerificationService {
    @Headers("Content-Type: application/x-www-form-urlencoded; charset=utf-8")
    @POST("/recaptcha/api/siteverify")
    fun verifyResponse(@QueryMap params: Map<String?, String?>): Response<RecaptchaVerifyResponse>
}