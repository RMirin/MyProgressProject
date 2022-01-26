package com.example.recaptcha.response

import com.google.gson.annotations.SerializedName

data class RecaptchaVerifyResponse(
    @SerializedName("success") var success: Boolean,
    @SerializedName("challenge_ts") var timestamp: String,
    @SerializedName("apk_package_name") var apkPackageName: String,
    @SerializedName("error-codes") var errorCodes: List<String>
)