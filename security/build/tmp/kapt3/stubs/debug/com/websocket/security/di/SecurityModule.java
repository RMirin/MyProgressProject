package com.example.security.di;

import java.lang.System;

@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0007J\u0012\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\rH\u0007J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fH\u0007\u00a8\u0006\u0010"}, d2 = {"Lcom/websocket/security/di/SecurityModule;", "", "()V", "provideSecurityRepository", "Lcom/websocket/security/repository/SecurityRepository;", "sessionStoreService", "Lcom/websocket/security/service/SessionStoreService;", "provideSecurityUseCase", "Lcom/websocket/security/usecases/SecurityUseCase;", "securityRepository", "secureSharedPreferences", "Landroid/content/SharedPreferences;", "context", "Landroid/content/Context;", "sessionStore", "Lcom/websocket/security/sessionstore/SessionStore;", "security_debug"})
@dagger.Module()
public final class SecurityModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.security.di.SecurityModule INSTANCE = null;
    
    private SecurityModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final android.content.SharedPreferences secureSharedPreferences(@org.jetbrains.annotations.NotNull()
    @dagger.hilt.android.qualifiers.ApplicationContext()
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final com.example.security.usecases.SecurityUseCase provideSecurityUseCase(@org.jetbrains.annotations.NotNull()
    com.example.security.repository.SecurityRepository securityRepository) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final com.example.security.repository.SecurityRepository provideSecurityRepository(@org.jetbrains.annotations.NotNull()
    com.example.security.service.SessionStoreService sessionStoreService) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.example.security.service.SessionStoreService sessionStoreService(@org.jetbrains.annotations.NotNull()
    com.example.security.sessionstore.SessionStore sessionStore) {
        return null;
    }
}