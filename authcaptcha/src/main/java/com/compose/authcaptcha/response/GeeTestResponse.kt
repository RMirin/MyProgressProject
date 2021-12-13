package com.compose.authcaptcha.response

import com.google.gson.annotations.SerializedName

data class GeeTestResponse(
    val success: Int,
    val challenge: String,
    val gt: String,
    @SerializedName("new_captcha")
    val newCaptcha: Boolean
)