package com.example.security.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/websocket/security/repository/SecurityRepositoryImpl;", "Lcom/websocket/security/repository/SecurityRepository;", "Lcom/websocket/security/base/BaseRepository;", "sessionStoreService", "Lcom/websocket/security/service/SessionStoreService;", "(Lcom/websocket/security/service/SessionStoreService;)V", "getCaptchaParams", "", "time", "", "security_debug"})
@javax.inject.Singleton()
public final class SecurityRepositoryImpl extends com.example.security.base.BaseRepository implements com.example.security.repository.SecurityRepository {
    private final com.example.security.service.SessionStoreService sessionStoreService = null;
    
    @javax.inject.Inject()
    public SecurityRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.example.security.service.SessionStoreService sessionStoreService) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String getCaptchaParams(long time) {
        return null;
    }
}