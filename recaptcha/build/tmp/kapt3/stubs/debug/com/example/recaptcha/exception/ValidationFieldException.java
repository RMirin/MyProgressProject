package com.example.recaptcha.exception;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\u0002\u0010\u0006R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/example/recaptcha/exception/ValidationFieldException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "errorList", "", "Lcom/example/recaptcha/exception/FieldException;", "(Ljava/util/List;)V", "getErrorList", "()Ljava/util/List;", "recaptcha_debug"})
public final class ValidationFieldException extends java.lang.Exception {
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.example.recaptcha.exception.FieldException> errorList = null;
    
    public ValidationFieldException(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.recaptcha.exception.FieldException> errorList) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.recaptcha.exception.FieldException> getErrorList() {
        return null;
    }
}