package com.example.recaptcha.extension

import android.util.Log
import com.example.recaptcha.base.BasicError
import com.example.recaptcha.base.FieldErrorResponse
import com.example.recaptcha.exception.RestExceptionFactory
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import retrofit2.Response
import java.io.File
import java.io.FileNotFoundException

inline fun <reified T> Response<T>.checkResponse(): T? {
    if (isSuccessful) return body()

    if (body() == null && errorBody() == null) {
        throw RuntimeException("Both body() and errorBody() are null")
    } else {
        if (errorBody() != null) {
            val code = code()
            val errorBody = errorBody()?.string()

            val errorResponse: Any? = when {
                code in 400..499 -> {
                    if (errorBody?.contains("violations") == true) {
                        val typeToken = TypeToken.get(FieldErrorResponse::class.java).type
                        Gson().fromJson<FieldErrorResponse>(errorBody, typeToken)
                    } else {
                        val typeToken = TypeToken.get(BasicError::class.java).type
                        Gson().fromJson<BasicError>(errorBody, typeToken)
                    }
                }
                code >= 500 -> {
                    val typeToken = TypeToken.get(InternalError::class.java).type
                    Gson().fromJson<InternalError>(errorBody, typeToken)
                }
                else -> null
            }

            RestExceptionFactory.checkErrorList(errorResponse)
        }
    }

    return body()
}


