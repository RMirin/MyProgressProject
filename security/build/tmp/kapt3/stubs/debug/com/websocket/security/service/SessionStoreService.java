package com.example.security.service;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u0018\u0010\u0002\u001a\u00020\u0003X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/websocket/security/service/SessionStoreService;", "", "uuId", "", "getUuId", "()Ljava/lang/String;", "setUuId", "(Ljava/lang/String;)V", "security_debug"})
public abstract interface SessionStoreService {
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String getUuId();
    
    public abstract void setUuId(@org.jetbrains.annotations.NotNull()
    java.lang.String p0);
}