package com.example.security.service;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R$\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\u000e"}, d2 = {"Lcom/websocket/security/service/SessionStoreServiceImpl;", "Lcom/websocket/security/service/SessionStoreService;", "sessionStore", "Lcom/websocket/security/sessionstore/SessionStore;", "(Lcom/websocket/security/sessionstore/SessionStore;)V", "getSessionStore", "()Lcom/websocket/security/sessionstore/SessionStore;", "value", "", "uuId", "getUuId", "()Ljava/lang/String;", "setUuId", "(Ljava/lang/String;)V", "security_debug"})
public final class SessionStoreServiceImpl implements com.example.security.service.SessionStoreService {
    @org.jetbrains.annotations.NotNull()
    private final com.example.security.sessionstore.SessionStore sessionStore = null;
    
    @javax.inject.Inject()
    public SessionStoreServiceImpl(@org.jetbrains.annotations.NotNull()
    com.example.security.sessionstore.SessionStore sessionStore) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.security.sessionstore.SessionStore getSessionStore() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String getUuId() {
        return null;
    }
    
    @java.lang.Override()
    public void setUuId(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
}