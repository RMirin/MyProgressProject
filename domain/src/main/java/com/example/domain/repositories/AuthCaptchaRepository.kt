package com.example.domain.repositories

import com.example.core.base.State
import kotlinx.coroutines.flow.Flow
import org.json.JSONObject

interface AuthCaptchaRepository {
    suspend fun getCaptchaParams(): Flow<State<JSONObject?>>
}