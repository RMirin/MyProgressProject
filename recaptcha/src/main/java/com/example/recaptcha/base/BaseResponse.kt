package com.example.recaptcha.base

import com.google.gson.annotations.SerializedName

class BasicError(
    @SerializedName("title")
    val title: String = "",
    @SerializedName("detail")
    val message: String = ""
)

data class FieldErrorResponse(
    @SerializedName("violations")
    val errorList: List<FieldError> = listOf()
)

data class FieldError(
    @SerializedName("propertyPath")
    val field: String = "",
    @SerializedName("message")
    val message: String = "",
    @SerializedName("code")
    val errorCode: String = ""
)

data class InternalError(
    @SerializedName("title")
    val message: String = "",
    @SerializedName("errorCode")
    val errorCode: String = ""
)