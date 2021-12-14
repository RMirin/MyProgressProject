package com.compose.authcaptcha.repository

import com.compose.authcaptcha.base.BaseRepository
import com.compose.authcaptcha.base.State
import com.compose.authcaptcha.service.ApiService
import kotlinx.coroutines.flow.Flow
import org.json.JSONObject
import javax.inject.Inject
import javax.inject.Singleton

interface AuthCaptchaRepository {
    suspend fun getCaptchaParams(time: Long): Flow<State<JSONObject?>>
}

@Singleton
class AuthCaptchaRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : AuthCaptchaRepository, BaseRepository() {

    override suspend fun getCaptchaParams(time: Long): Flow<State<JSONObject?>> = apiCall {
        JSONObject(apiService.getCaptcha(time).string())
    }
}