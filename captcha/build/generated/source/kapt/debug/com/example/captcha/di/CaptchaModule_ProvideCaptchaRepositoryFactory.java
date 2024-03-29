// Generated by Dagger (https://dagger.dev).
package com.example.captcha.di;

import com.example.captcha.data.api.GeeTestApi;
import com.example.captcha.domain.repository.CaptchaRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class CaptchaModule_ProvideCaptchaRepositoryFactory implements Factory<CaptchaRepository> {
  private final Provider<GeeTestApi> geeTestApiProvider;

  public CaptchaModule_ProvideCaptchaRepositoryFactory(Provider<GeeTestApi> geeTestApiProvider) {
    this.geeTestApiProvider = geeTestApiProvider;
  }

  @Override
  public CaptchaRepository get() {
    return provideCaptchaRepository(geeTestApiProvider.get());
  }

  public static CaptchaModule_ProvideCaptchaRepositoryFactory create(
      Provider<GeeTestApi> geeTestApiProvider) {
    return new CaptchaModule_ProvideCaptchaRepositoryFactory(geeTestApiProvider);
  }

  public static CaptchaRepository provideCaptchaRepository(GeeTestApi geeTestApi) {
    return Preconditions.checkNotNullFromProvides(CaptchaModule.INSTANCE.provideCaptchaRepository(geeTestApi));
  }
}
