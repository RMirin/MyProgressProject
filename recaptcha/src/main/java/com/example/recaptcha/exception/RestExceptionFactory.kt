package com.example.recaptcha.exception

import com.example.recaptcha.base.BasicError
import com.example.recaptcha.base.FieldErrorResponse
import com.example.recaptcha.base.InternalError

object RestExceptionFactory {

    fun checkErrorList(error: Any?) {
        throw when (error) {
            is BasicError -> ClientException(error.title)
            is FieldErrorResponse -> {
                val fieldErrorList = mutableListOf<FieldException>()

                error.errorList.forEach { fieldError ->
                    fieldErrorList.add(FieldException(fieldError.message))
                }

                ValidationFieldException(fieldErrorList)
            }
            is InternalError -> ClientException(error.errorCode)
            else -> RemoteException()
        }
    }

}