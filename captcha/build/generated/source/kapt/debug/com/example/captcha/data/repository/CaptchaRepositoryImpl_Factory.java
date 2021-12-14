// Generated by Dagger (https://dagger.dev).
package com.example.captcha.data.repository;

import com.example.captcha.data.api.GeeTestApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import javax.inject.Provider;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class CaptchaRepositoryImpl_Factory implements Factory<CaptchaRepositoryImpl> {
  private final Provider<GeeTestApi> geeTestApiProvider;

  public CaptchaRepositoryImpl_Factory(Provider<GeeTestApi> geeTestApiProvider) {
    this.geeTestApiProvider = geeTestApiProvider;
  }

  @Override
  public CaptchaRepositoryImpl get() {
    return newInstance(geeTestApiProvider.get());
  }

  public static CaptchaRepositoryImpl_Factory create(Provider<GeeTestApi> geeTestApiProvider) {
    return new CaptchaRepositoryImpl_Factory(geeTestApiProvider);
  }

  public static CaptchaRepositoryImpl newInstance(GeeTestApi geeTestApi) {
    return new CaptchaRepositoryImpl(geeTestApi);
  }
}