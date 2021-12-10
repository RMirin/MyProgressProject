package com.example.domain.usecases

import com.example.core.base.State
import com.example.domain.repositories.AuthCaptchaRepository
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
        return authCaptchaRepository.getCaptchaParams()
    }
}