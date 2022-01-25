// Generated by Dagger (https://dagger.dev).
package com.example.security.di;

import android.content.Context;
import android.content.SharedPreferences;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class SecurityModule_SecureSharedPreferencesFactory implements Factory<SharedPreferences> {
  private final Provider<Context> contextProvider;

  public SecurityModule_SecureSharedPreferencesFactory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public SharedPreferences get() {
    return secureSharedPreferences(contextProvider.get());
  }

  public static SecurityModule_SecureSharedPreferencesFactory create(
      Provider<Context> contextProvider) {
    return new SecurityModule_SecureSharedPreferencesFactory(contextProvider);
  }

  public static SharedPreferences secureSharedPreferences(Context context) {
    return Preconditions.checkNotNullFromProvides(SecurityModule.INSTANCE.secureSharedPreferences(context));
  }
}
