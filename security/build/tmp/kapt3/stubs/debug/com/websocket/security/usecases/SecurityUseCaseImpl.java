package com.example.security.usecases;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/websocket/security/usecases/SecurityUseCaseImpl;", "Lcom/websocket/security/usecases/SecurityUseCase;", "securityRepository", "Lcom/websocket/security/repository/SecurityRepository;", "(Lcom/websocket/security/repository/SecurityRepository;)V", "getCaptchaParams", "", "security_debug"})
@javax.inject.Singleton()
public final class SecurityUseCaseImpl implements com.example.security.usecases.SecurityUseCase {
    private final com.example.security.repository.SecurityRepository securityRepository = null;
    
    @javax.inject.Inject()
    public SecurityUseCaseImpl(@org.jetbrains.annotations.NotNull()
    com.example.security.repository.SecurityRepository securityRepository) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.String getCaptchaParams() {
        return null;
    }
}