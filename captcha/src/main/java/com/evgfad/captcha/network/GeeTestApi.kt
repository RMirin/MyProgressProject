package com.evgfad.captcha.network

import com.evgfad.captcha.CaptchaRegisterModel
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Response
import retrofit2.http.GET

interface GeeTestApi {

    @GET("register-slide")
    suspend fun registerSlide() : Response<CaptchaRegisterModel>
}