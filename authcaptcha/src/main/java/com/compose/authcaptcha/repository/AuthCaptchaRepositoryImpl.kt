package com.compose.authcaptcha.repository

import com.compose.authcaptcha.service.ApiService
import com.example.core.base.BaseRepository
import com.example.core.base.State
import com.example.domain.repositories.AuthCaptchaRepository
import kotlinx.coroutines.flow.Flow
import org.json.JSONObject
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthCaptchaRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : AuthCaptchaRepository, BaseRepository() {

    override suspend fun getCaptchaParams(): Flow<State<JSONObject?>> = apiCall {
        JSONObject(apiService.getCaptcha().toString())
    }
}