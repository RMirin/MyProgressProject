package com.example.captcha.domain.usecase

import com.example.captcha.domain.repository.CaptchaRepository
import com.example.captcha.util.State
import kotlinx.coroutines.flow.Flow
import org.json.JSONObject
import javax.inject.Inject

class CaptchaUseCase @Inject constructor(private val captchaRepository: CaptchaRepository) {
    suspend fun registerSlide(): Flow<State<JSONObject?>> =
        captchaRepository.registerSlide(getCurrentTimeMills())

    private fun getCurrentTimeMills(): Long = System.currentTimeMillis()
}