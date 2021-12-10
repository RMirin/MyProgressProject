package com.evgfad.captcha

data class CaptchaRegisterModel(
    val challenge: String,
    val gt: String,
    val new_captcha: Boolean,
    val success: Int
)