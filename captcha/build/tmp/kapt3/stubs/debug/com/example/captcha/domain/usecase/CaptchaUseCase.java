package com.example.captcha.domain.usecase;

import com.example.captcha.domain.repository.CaptchaRepository;
import com.example.captcha.util.State;
import kotlinx.coroutines.flow.Flow;
import org.json.JSONObject;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0002J\u001f\u0010\u0007\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t0\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\f"}, d2 = {"Lcom/example/captcha/domain/usecase/CaptchaUseCase;", "", "captchaRepository", "Lcom/example/captcha/domain/repository/CaptchaRepository;", "(Lcom/example/captcha/domain/repository/CaptchaRepository;)V", "getCurrentTimeMills", "", "registerSlide", "Lkotlinx/coroutines/flow/Flow;", "Lcom/example/captcha/util/State;", "Lorg/json/JSONObject;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "captcha_debug"})
public final class CaptchaUseCase {
    private final com.example.captcha.domain.repository.CaptchaRepository captchaRepository = null;
    
    @javax.inject.Inject()
    public CaptchaUseCase(@org.jetbrains.annotations.NotNull()
    com.example.captcha.domain.repository.CaptchaRepository captchaRepository) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object registerSlide(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends com.example.captcha.util.State<? extends org.json.JSONObject>>> continuation) {
        return null;
    }
    
    private final long getCurrentTimeMills() {
        return 0L;
    }
}