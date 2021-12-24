package com.example.captcha.di;

import com.example.captcha.data.api.GeeTestApi;
import com.example.captcha.data.repository.CaptchaRepositoryImpl;
import com.example.captcha.domain.repository.CaptchaRepository;
import com.example.captcha.domain.usecase.CaptchaUseCase;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import javax.inject.Singleton;

@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0007J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0007J\b\u0010\r\u001a\u00020\fH\u0007\u00a8\u0006\u000e"}, d2 = {"Lcom/example/captcha/di/CaptchaModule;", "", "()V", "provideCaptchaRepository", "Lcom/example/captcha/domain/repository/CaptchaRepository;", "geeTestApi", "Lcom/example/captcha/data/api/GeeTestApi;", "provideCaptchaUseCase", "Lcom/example/captcha/domain/usecase/CaptchaUseCase;", "captchaRepository", "provideGeeTestApi", "client", "Lokhttp3/OkHttpClient;", "provideOkHttpClient", "captcha_debug"})
@dagger.Module()
public final class CaptchaModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.captcha.di.CaptchaModule INSTANCE = null;
    
    private CaptchaModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.example.captcha.domain.repository.CaptchaRepository provideCaptchaRepository(@org.jetbrains.annotations.NotNull()
    com.example.captcha.data.api.GeeTestApi geeTestApi) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.example.captcha.domain.usecase.CaptchaUseCase provideCaptchaUseCase(@org.jetbrains.annotations.NotNull()
    com.example.captcha.domain.repository.CaptchaRepository captchaRepository) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final okhttp3.OkHttpClient provideOkHttpClient() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final com.example.captcha.data.api.GeeTestApi provideGeeTestApi(@org.jetbrains.annotations.NotNull()
    okhttp3.OkHttpClient client) {
        return null;
    }
}