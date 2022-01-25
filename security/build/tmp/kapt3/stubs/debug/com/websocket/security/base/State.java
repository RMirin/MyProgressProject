package com.example.security.base;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002:\u0003\u0004\u0005\u0006B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t\u00a8\u0006\n"}, d2 = {"Lcom/websocket/security/base/State;", "T", "", "()V", "Error", "Loading", "Success", "Lcom/websocket/security/base/State$Loading;", "Lcom/websocket/security/base/State$Success;", "Lcom/websocket/security/base/State$Error;", "security_debug"})
public abstract class State<T extends java.lang.Object> {
    
    private State() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/websocket/security/base/State$Loading;", "Lcom/websocket/security/base/State;", "", "()V", "security_debug"})
    public static final class Loading extends com.example.security.base.State {
        @org.jetbrains.annotations.NotNull()
        public static final com.example.security.base.State.Loading INSTANCE = null;
        
        private Loading() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00028\u0001\u00a2\u0006\u0002\u0010\u0004R\u0013\u0010\u0003\u001a\u00028\u0001\u00a2\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\b"}, d2 = {"Lcom/websocket/security/base/State$Success;", "T", "Lcom/websocket/security/base/State;", "data", "(Ljava/lang/Object;)V", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "security_debug"})
    public static final class Success<T extends java.lang.Object> extends com.example.security.base.State<T> {
        private final T data = null;
        
        public Success(T data) {
            super();
        }
        
        public final T getData() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/websocket/security/base/State$Error;", "Lcom/websocket/security/base/State;", "", "exception", "", "(Ljava/lang/Throwable;)V", "getException", "()Ljava/lang/Throwable;", "security_debug"})
    public static final class Error extends com.example.security.base.State {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.Throwable exception = null;
        
        public Error(@org.jetbrains.annotations.NotNull()
        java.lang.Throwable exception) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.Throwable getException() {
            return null;
        }
    }
}