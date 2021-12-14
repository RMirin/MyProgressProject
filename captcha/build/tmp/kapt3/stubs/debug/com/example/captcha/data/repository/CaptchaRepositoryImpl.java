package com.example.captcha.data.repository;

import com.example.captcha.base.BaseRepository;
import com.example.captcha.data.api.GeeTestApi;
import com.example.captcha.domain.repository.CaptchaRepository;
import com.example.captcha.util.State;
import kotlinx.coroutines.flow.Flow;
import org.json.JSONObject;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\'\u0010\u0006\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b0\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\r"}, d2 = {"Lcom/example/captcha/data/repository/CaptchaRepositoryImpl;", "Lcom/example/captcha/domain/repository/CaptchaRepository;", "Lcom/example/captcha/base/BaseRepository;", "geeTestApi", "Lcom/example/captcha/data/api/GeeTestApi;", "(Lcom/example/captcha/data/api/GeeTestApi;)V", "registerSlide", "Lkotlinx/coroutines/flow/Flow;", "Lcom/example/captcha/util/State;", "Lorg/json/JSONObject;", "time", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "captcha_debug"})
public final class CaptchaRepositoryImpl extends com.example.captcha.base.BaseRepository implements com.example.captcha.domain.repository.CaptchaRepository {
    private final com.example.captcha.data.api.GeeTestApi geeTestApi = null;
    
    @javax.inject.Inject()
    public CaptchaRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.example.captcha.data.api.GeeTestApi geeTestApi) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object registerSlide(long time, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends com.example.captcha.util.State<? extends org.json.JSONObject>>> continuation) {
        return null;
    }
}