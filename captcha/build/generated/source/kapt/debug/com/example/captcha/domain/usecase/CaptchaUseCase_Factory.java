// Generated by Dagger (https://dagger.dev).
package com.example.captcha.domain.usecase;

import com.example.captcha.domain.repository.CaptchaRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import javax.inject.Provider;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class CaptchaUseCase_Factory implements Factory<CaptchaUseCase> {
  private final Provider<CaptchaRepository> captchaRepositoryProvider;

  public CaptchaUseCase_Factory(Provider<CaptchaRepository> captchaRepositoryProvider) {
    this.captchaRepositoryProvider = captchaRepositoryProvider;
  }

  @Override
  public CaptchaUseCase get() {
    return newInstance(captchaRepositoryProvider.get());
  }

  public static CaptchaUseCase_Factory create(
      Provider<CaptchaRepository> captchaRepositoryProvider) {
    return new CaptchaUseCase_Factory(captchaRepositoryProvider);
  }

  public static CaptchaUseCase newInstance(CaptchaRepository captchaRepository) {
    return new CaptchaUseCase(captchaRepository);
  }
}
