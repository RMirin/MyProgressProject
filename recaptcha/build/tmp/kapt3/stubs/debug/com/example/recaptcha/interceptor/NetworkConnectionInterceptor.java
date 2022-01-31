package com.example.recaptcha.interceptor;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/example/recaptcha/interceptor/NetworkConnectionInterceptor;", "Lokhttp3/Interceptor;", "networkService", "Lcom/example/recaptcha/service/NetworkService;", "(Lcom/example/recaptcha/service/NetworkService;)V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "recaptcha_debug"})
public final class NetworkConnectionInterceptor implements okhttp3.Interceptor {
    private final com.example.recaptcha.service.NetworkService networkService = null;
    
    public NetworkConnectionInterceptor(@org.jetbrains.annotations.NotNull()
    com.example.recaptcha.service.NetworkService networkService) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public okhttp3.Response intercept(@org.jetbrains.annotations.NotNull()
    okhttp3.Interceptor.Chain chain) {
        return null;
    }
}