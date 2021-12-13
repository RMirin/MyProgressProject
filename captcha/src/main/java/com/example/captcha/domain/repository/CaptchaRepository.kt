package com.example.captcha.domain.repository

import com.example.captcha.util.State
import kotlinx.coroutines.flow.Flow
import org.json.JSONObject

interface CaptchaRepository {
    suspend fun registerSlide(time: Long): Flow<State<JSONObject?>>
}