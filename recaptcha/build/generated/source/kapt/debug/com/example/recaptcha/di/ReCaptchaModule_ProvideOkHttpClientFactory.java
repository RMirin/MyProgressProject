// Generated by Dagger (https://dagger.dev).
package com.example.recaptcha.di;

import com.example.recaptcha.service.NetworkService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class ReCaptchaModule_ProvideOkHttpClientFactory implements Factory<OkHttpClient> {
  private final Provider<NetworkService> networkServiceProvider;

  public ReCaptchaModule_ProvideOkHttpClientFactory(
      Provider<NetworkService> networkServiceProvider) {
    this.networkServiceProvider = networkServiceProvider;
  }

  @Override
  public OkHttpClient get() {
    return provideOkHttpClient(networkServiceProvider.get());
  }

  public static ReCaptchaModule_ProvideOkHttpClientFactory create(
      Provider<NetworkService> networkServiceProvider) {
    return new ReCaptchaModule_ProvideOkHttpClientFactory(networkServiceProvider);
  }

  public static OkHttpClient provideOkHttpClient(NetworkService networkService) {
    return Preconditions.checkNotNullFromProvides(ReCaptchaModule.INSTANCE.provideOkHttpClient(networkService));
  }
}
