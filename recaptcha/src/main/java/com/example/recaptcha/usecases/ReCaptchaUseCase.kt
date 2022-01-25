package com.example.recaptcha.usecases

import com.example.recaptcha.base.NetworkResult
import com.example.recaptcha.repository.ReCaptchaRepository
import com.example.recaptcha.response.RecaptchaVerifyResponse
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject
import javax.inject.Singleton

interface ReCaptchaUseCase {
    suspend fun validateCaptcha(
        data: MutableStateFlow<NetworkResult<RecaptchaVerifyResponse?>>,
        response: String,
        key: String
    ): MutableStateFlow<NetworkResult<RecaptchaVerifyResponse?>>
}

@Singleton
class ReCaptchaUseCaseImpl @Inject constructor(
    private val reCaptchaRepository: ReCaptchaRepository
) : ReCaptchaUseCase {
    override suspend fun validateCaptcha(
        data: MutableStateFlow<NetworkResult<RecaptchaVerifyResponse?>>,
        response: String,
        key: String
    ): MutableStateFlow<NetworkResult<RecaptchaVerifyResponse?>> {
        return reCaptchaRepository.validateCaptcha(data, response, key)
    }
}