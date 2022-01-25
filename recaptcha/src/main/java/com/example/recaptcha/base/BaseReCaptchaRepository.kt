package com.example.recaptcha.base

import kotlinx.coroutines.flow.*

open class BaseReCaptchaRepository {

    protected suspend fun <T : Any?> apiCall(
        data: MutableStateFlow<NetworkResult<T>>,
        action: suspend () -> NetworkResult<T>
    ): MutableStateFlow<NetworkResult<T>> {
        data.emit(NetworkResult.Loading())
        try {
            data.emit(action.invoke())
        } catch (e: Exception) {
            data.emit(NetworkResult.Error(e.message))
        }
        return data
    }
}