package com.example.data.local.repository

import com.evgfad.captcha.network.GeeTestApi
import com.example.domain.entity.CaptchaRegisterModel
import com.example.domain.repositories.CaptchaRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CaptchaRepositoryImpl @Inject constructor(private val geeTestApi: GeeTestApi) :
    CaptchaRepository {
    override fun registerSlide(): Flow<CaptchaRegisterModel> {
        return geeTestApi.registerSlide()
    }
}