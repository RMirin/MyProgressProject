// Generated by Dagger (https://dagger.dev).
package com.compose.androidwebsocket.di;

import android.content.Context;
import com.compose.androidwebsocket.service.NetworkService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class AndroidWebSocketModule_ProvideNetworkServiceFactory implements Factory<NetworkService> {
  private final Provider<Context> contextProvider;

  public AndroidWebSocketModule_ProvideNetworkServiceFactory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public NetworkService get() {
    return provideNetworkService(contextProvider.get());
  }

  public static AndroidWebSocketModule_ProvideNetworkServiceFactory create(
      Provider<Context> contextProvider) {
    return new AndroidWebSocketModule_ProvideNetworkServiceFactory(contextProvider);
  }

  public static NetworkService provideNetworkService(Context context) {
    return Preconditions.checkNotNullFromProvides(AndroidWebSocketModule.INSTANCE.provideNetworkService(context));
  }
}
