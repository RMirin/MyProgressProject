package com.compose.authcaptcha.usecases

import com.compose.authcaptcha.base.State
import com.compose.authcaptcha.repository.AuthCaptchaRepository
import kotlinx.coroutines.flow.Flow
import org.json.JSONObject
import javax.inject.Inject
import javax.inject.Singleton

interface AuthCaptchaUseCase {
    suspend fun getCaptchaParams(): Flow<State<JSONObject?>>
}

@Singleton
class AuthCaptchaUseCaseImpl @Inject constructor(
    private val authCaptchaRepository: AuthCaptchaRepository
) : AuthCaptchaUseCase {

    override suspend fun getCaptchaParams(): Flow<State<JSONObject?>> {
        return authCaptchaRepository.getCaptchaParams(System.currentTimeMillis())
    }
}