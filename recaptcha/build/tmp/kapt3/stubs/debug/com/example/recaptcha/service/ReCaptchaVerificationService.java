package com.example.recaptcha.service;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J1\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0018\b\u0001\u0010\u0005\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\t"}, d2 = {"Lcom/example/recaptcha/service/ReCaptchaVerificationService;", "", "verifyResponse", "Lretrofit2/Response;", "Lcom/example/recaptcha/response/RecaptchaVerifyResponse;", "params", "", "", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "recaptcha_debug"})
public abstract interface ReCaptchaVerificationService {
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "/recaptcha/api/siteverify")
    @retrofit2.http.Headers(value = {"Content-Type: application/x-www-form-urlencoded; charset=utf-8"})
    public abstract java.lang.Object verifyResponse(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.QueryMap()
    java.util.Map<java.lang.String, java.lang.String> params, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.example.recaptcha.response.RecaptchaVerifyResponse>> continuation);
}