package com.compose.authcaptcha.response

import com.google.gson.annotations.SerializedName

data class GeeTestResponse(
    @SerializedName("success")
    val success: Int,
    @SerializedName("challenge")
    val challenge: String,
    @SerializedName("gt")
    val gt: String,
    @SerializedName("new_captcha")
    val newCaptcha: Boolean
)