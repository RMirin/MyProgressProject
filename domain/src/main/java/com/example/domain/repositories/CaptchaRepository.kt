package com.example.domain.repositories

import com.example.domain.entity.CaptchaRegisterModel
import kotlinx.coroutines.flow.Flow

interface CaptchaRepository {
    fun registerSlide():Flow<CaptchaRegisterModel>
}