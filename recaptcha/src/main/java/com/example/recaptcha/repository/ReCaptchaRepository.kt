package com.example.recaptcha.repository

import android.util.Log
import com.example.recaptcha.base.NetworkResult
import com.example.recaptcha.extension.checkResponse
import com.example.recaptcha.response.RecaptchaVerifyResponse
import com.example.recaptcha.service.ReCaptchaVerificationService
import com.example.recaptcha.base.BaseReCaptchaRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import org.json.JSONObject
import javax.inject.Inject
import javax.inject.Singleton

interface ReCaptchaRepository {
    suspend fun validateCaptcha(data: MutableStateFlow<NetworkResult<RecaptchaVerifyResponse?>>, response: String, key: String): MutableStateFlow<NetworkResult<RecaptchaVerifyResponse?>>
}

@Singleton
class ReCaptchaRepositoryImpl @Inject constructor(
    private val recaptchaVerificationService: ReCaptchaVerificationService
) : ReCaptchaRepository, BaseReCaptchaRepository() {

//    override suspend fun validateCaptcha(data: MutableStateFlow<NetworkResult<RecaptchaVerifyResponse?>>, response: String, key: String) : RecaptchaVerifyResponse? {
//        var resultData: RecaptchaVerifyResponse? = null
//        Log.e("TAG", "validateCaptcha: data ${data}")
//        Log.e("TAG", "validateCaptcha response: ${response}")
//        Log.e("TAG", "validateCaptcha key: ${key}")
//        apiCall(data) {
//            val params: MutableMap<String?, String?> = HashMap()
//            params["response"] = response
//            params["secret"] = key
//            val result = recaptchaVerificationService.verifyResponse(params).checkResponse()
//            resultData = result
//            result
//        }
//
//        Log.e("TAG", "validateCaptcha: result ${resultData}")
//        return resultData
//    }

    override suspend fun validateCaptcha(
        data: MutableStateFlow<NetworkResult<RecaptchaVerifyResponse?>>,
        response: String,
        key: String
    ): MutableStateFlow<NetworkResult<RecaptchaVerifyResponse?>> {
        return apiCall(data) {
            val params: MutableMap<String?, String?> = HashMap()
            params["response"] = response
            params["secret"] = key
            val result = NetworkResult.Success(
                recaptchaVerificationService.verifyResponse(params).checkResponse()
            )
            result
        }
    }
}

