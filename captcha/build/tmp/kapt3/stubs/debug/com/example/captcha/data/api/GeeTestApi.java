package com.example.captcha.data.api;

import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Query;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0007"}, d2 = {"Lcom/example/captcha/data/api/GeeTestApi;", "", "registerSlide", "Lokhttp3/ResponseBody;", "t", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "captcha_debug"})
public abstract interface GeeTestApi {
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "register-slide")
    public abstract java.lang.Object registerSlide(@retrofit2.http.Query(value = "t")
    long t, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super okhttp3.ResponseBody> continuation);
}