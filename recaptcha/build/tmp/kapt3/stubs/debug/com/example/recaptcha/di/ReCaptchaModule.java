package com.example.recaptcha.di;

import java.lang.System;

@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000bH\u0007J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\bH\u0007\u00a8\u0006\u0013"}, d2 = {"Lcom/example/recaptcha/di/ReCaptchaModule;", "", "()V", "provideNetworkService", "Lcom/example/recaptcha/service/NetworkService;", "context", "Landroid/content/Context;", "provideOkHttpClient", "Lokhttp3/OkHttpClient;", "networkService", "provideReCaptchaRepository", "Lcom/example/recaptcha/repository/ReCaptchaRepository;", "recaptchaVerificationService", "Lcom/example/recaptcha/service/ReCaptchaVerificationService;", "provideReCaptchaUseCase", "Lcom/example/recaptcha/usecases/ReCaptchaUseCase;", "reCaptchaRepository", "provideRetrofit", "okHttpClient", "recaptcha_debug"})
@dagger.Module()
public final class ReCaptchaModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.recaptcha.di.ReCaptchaModule INSTANCE = null;
    
    private ReCaptchaModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.example.recaptcha.service.NetworkService provideNetworkService(@org.jetbrains.annotations.NotNull()
    @dagger.hilt.android.qualifiers.ApplicationContext()
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final okhttp3.OkHttpClient provideOkHttpClient(@org.jetbrains.annotations.NotNull()
    com.example.recaptcha.service.NetworkService networkService) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.example.recaptcha.service.ReCaptchaVerificationService provideRetrofit(@org.jetbrains.annotations.NotNull()
    okhttp3.OkHttpClient okHttpClient) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.example.recaptcha.repository.ReCaptchaRepository provideReCaptchaRepository(@org.jetbrains.annotations.NotNull()
    com.example.recaptcha.service.ReCaptchaVerificationService recaptchaVerificationService) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.example.recaptcha.usecases.ReCaptchaUseCase provideReCaptchaUseCase(@org.jetbrains.annotations.NotNull()
    com.example.recaptcha.repository.ReCaptchaRepository reCaptchaRepository) {
        return null;
    }
}