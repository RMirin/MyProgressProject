// Generated by Dagger (https://dagger.dev).
package com.compose.androidwebsocket.di;

import com.compose.androidwebsocket.data.remote.HitBtcApi;
import com.compose.androidwebsocket.data.remote.HitBtcClientImpl;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class AndroidWebSocketModule_ProvideHitBtcClientImplFactory implements Factory<HitBtcClientImpl> {
  private final Provider<HitBtcApi> hitBtcApiProvider;

  public AndroidWebSocketModule_ProvideHitBtcClientImplFactory(
      Provider<HitBtcApi> hitBtcApiProvider) {
    this.hitBtcApiProvider = hitBtcApiProvider;
  }

  @Override
  public HitBtcClientImpl get() {
    return provideHitBtcClientImpl(hitBtcApiProvider.get());
  }

  public static AndroidWebSocketModule_ProvideHitBtcClientImplFactory create(
      Provider<HitBtcApi> hitBtcApiProvider) {
    return new AndroidWebSocketModule_ProvideHitBtcClientImplFactory(hitBtcApiProvider);
  }

  public static HitBtcClientImpl provideHitBtcClientImpl(HitBtcApi hitBtcApi) {
    return Preconditions.checkNotNullFromProvides(AndroidWebSocketModule.INSTANCE.provideHitBtcClientImpl(hitBtcApi));
  }
}
