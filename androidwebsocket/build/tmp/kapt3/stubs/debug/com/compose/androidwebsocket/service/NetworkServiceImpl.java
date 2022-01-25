package com.compose.androidwebsocket.service;

import java.lang.System;

@kotlin.Suppress(names = {"DEPRECATION"})
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0007R\u0018\u0010\b\u001a\u00020\u0006*\u00020\t8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/compose/androidwebsocket/service/NetworkServiceImpl;", "Lcom/compose/androidwebsocket/service/NetworkService;", "connectivityManager", "Landroid/net/ConnectivityManager;", "(Landroid/net/ConnectivityManager;)V", "isNetworkAvailable", "", "()Z", "hasNetworkCapability", "Landroid/net/NetworkCapabilities;", "getHasNetworkCapability", "(Landroid/net/NetworkCapabilities;)Z", "androidwebsocket_debug"})
public final class NetworkServiceImpl implements com.compose.androidwebsocket.service.NetworkService {
    private final android.net.ConnectivityManager connectivityManager = null;
    
    @javax.inject.Inject()
    public NetworkServiceImpl(@org.jetbrains.annotations.NotNull()
    android.net.ConnectivityManager connectivityManager) {
        super();
    }
    
    @java.lang.Override()
    public boolean isNetworkAvailable() {
        return false;
    }
    
    private final boolean getHasNetworkCapability(android.net.NetworkCapabilities $this$hasNetworkCapability) {
        return false;
    }
}