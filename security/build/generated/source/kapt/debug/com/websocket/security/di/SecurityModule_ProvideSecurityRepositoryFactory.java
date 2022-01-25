// Generated by Dagger (https://dagger.dev).
package com.example.security.di;

import com.example.security.repository.SecurityRepository;
import com.example.security.service.SessionStoreService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class SecurityModule_ProvideSecurityRepositoryFactory implements Factory<SecurityRepository> {
  private final Provider<SessionStoreService> sessionStoreServiceProvider;

  public SecurityModule_ProvideSecurityRepositoryFactory(
      Provider<SessionStoreService> sessionStoreServiceProvider) {
    this.sessionStoreServiceProvider = sessionStoreServiceProvider;
  }

  @Override
  public SecurityRepository get() {
    return provideSecurityRepository(sessionStoreServiceProvider.get());
  }

  public static SecurityModule_ProvideSecurityRepositoryFactory create(
      Provider<SessionStoreService> sessionStoreServiceProvider) {
    return new SecurityModule_ProvideSecurityRepositoryFactory(sessionStoreServiceProvider);
  }

  public static SecurityRepository provideSecurityRepository(
      SessionStoreService sessionStoreService) {
    return Preconditions.checkNotNullFromProvides(SecurityModule.INSTANCE.provideSecurityRepository(sessionStoreService));
  }
}
