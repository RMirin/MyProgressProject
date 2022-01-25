package com.example.security.usecases;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&\u00a8\u0006\u0004"}, d2 = {"Lcom/websocket/security/usecases/SecurityUseCase;", "", "getCaptchaParams", "", "security_debug"})
public abstract interface SecurityUseCase {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.String getCaptchaParams();
}