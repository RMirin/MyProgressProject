package com.example.recaptcha.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005JE\u0010\u0006\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b0\u00072\u0014\u0010\n\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b0\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000f"}, d2 = {"Lcom/example/recaptcha/repository/ReCaptchaRepositoryImpl;", "Lcom/example/recaptcha/repository/ReCaptchaRepository;", "Lcom/example/recaptcha/base/BaseReCaptchaRepository;", "recaptchaVerificationService", "Lcom/example/recaptcha/service/ReCaptchaVerificationService;", "(Lcom/example/recaptcha/service/ReCaptchaVerificationService;)V", "validateCaptcha", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/example/recaptcha/base/NetworkResult;", "Lcom/example/recaptcha/response/RecaptchaVerifyResponse;", "data", "response", "", "key", "(Lkotlinx/coroutines/flow/MutableStateFlow;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "recaptcha_debug"})
@javax.inject.Singleton()
public final class ReCaptchaRepositoryImpl extends com.example.recaptcha.base.BaseReCaptchaRepository implements com.example.recaptcha.repository.ReCaptchaRepository {
    private final com.example.recaptcha.service.ReCaptchaVerificationService recaptchaVerificationService = null;
    
    @javax.inject.Inject()
    public ReCaptchaRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.example.recaptcha.service.ReCaptchaVerificationService recaptchaVerificationService) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object validateCaptcha(@org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.flow.MutableStateFlow<com.example.recaptcha.base.NetworkResult<com.example.recaptcha.response.RecaptchaVerifyResponse>> data, @org.jetbrains.annotations.NotNull()
    java.lang.String response, @org.jetbrains.annotations.NotNull()
    java.lang.String key, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.MutableStateFlow<com.example.recaptcha.base.NetworkResult<com.example.recaptcha.response.RecaptchaVerifyResponse>>> continuation) {
        return null;
    }
}