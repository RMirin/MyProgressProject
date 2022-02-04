package com.example.recaptcha.usecases;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004JE\u0010\u0005\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00070\u00062\u0014\u0010\t\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00070\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000e"}, d2 = {"Lcom/example/recaptcha/usecases/ReCaptchaUseCaseImpl;", "Lcom/example/recaptcha/usecases/ReCaptchaUseCase;", "reCaptchaRepository", "Lcom/example/recaptcha/repository/ReCaptchaRepository;", "(Lcom/example/recaptcha/repository/ReCaptchaRepository;)V", "validateCaptcha", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/example/recaptcha/base/NetworkResult;", "Lcom/example/recaptcha/response/RecaptchaVerifyResponse;", "data", "response", "", "key", "(Lkotlinx/coroutines/flow/MutableStateFlow;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "recaptcha_debug"})
@javax.inject.Singleton()
public final class ReCaptchaUseCaseImpl implements com.example.recaptcha.usecases.ReCaptchaUseCase {
    private final com.example.recaptcha.repository.ReCaptchaRepository reCaptchaRepository = null;
    
    @javax.inject.Inject()
    public ReCaptchaUseCaseImpl(@org.jetbrains.annotations.NotNull()
    com.example.recaptcha.repository.ReCaptchaRepository reCaptchaRepository) {
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