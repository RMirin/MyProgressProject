package com.example.recaptcha.usecases;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001JE\u0010\u0002\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00040\u00032\u0014\u0010\u0006\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00040\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000b"}, d2 = {"Lcom/example/recaptcha/usecases/ReCaptchaUseCase;", "", "validateCaptcha", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/example/recaptcha/base/NetworkResult;", "Lcom/example/recaptcha/response/RecaptchaVerifyResponse;", "data", "response", "", "key", "(Lkotlinx/coroutines/flow/MutableStateFlow;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "recaptcha_debug"})
public abstract interface ReCaptchaUseCase {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object validateCaptcha(@org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.flow.MutableStateFlow<com.example.recaptcha.base.NetworkResult<com.example.recaptcha.response.RecaptchaVerifyResponse>> data, @org.jetbrains.annotations.NotNull()
    java.lang.String response, @org.jetbrains.annotations.NotNull()
    java.lang.String key, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.MutableStateFlow<com.example.recaptcha.base.NetworkResult<com.example.recaptcha.response.RecaptchaVerifyResponse>>> continuation);
}