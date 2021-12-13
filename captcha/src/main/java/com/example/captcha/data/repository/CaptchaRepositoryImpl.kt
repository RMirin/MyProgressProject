package com.example.captcha.data.repository

import com.example.captcha.base.BaseRepository
import com.example.captcha.data.api.GeeTestApi
import com.example.captcha.domain.repository.CaptchaRepository
import com.example.captcha.util.State
import kotlinx.coroutines.flow.Flow
import org.json.JSONObject
import javax.inject.Inject

class CaptchaRepositoryImpl @Inject constructor(private val geeTestApi: GeeTestApi) :
    CaptchaRepository, BaseRepository() {
    override suspend fun registerSlide(time:Long): Flow<State<JSONObject?>> = apiCall {
        JSONObject(geeTestApi.registerSlide(time).string())
    }
}