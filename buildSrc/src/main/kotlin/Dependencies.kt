object Dependencies {
    //Base
    const val androidxCoreCoreKtx = "androidx.core:core-ktx:${Versions.androidxCoreCoreKtxVersion}"
    const val androidxAppcompatAppcompat = "androidx.appcompat:appcompat:${Versions.androidxAppcompatAppcompatVersion}"
    const val comGoogleAndroidMaterialMaterial = "com.google.android.material:material:${Versions.comGoogleAndroidMaterialMaterialVersion}"
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlinVersion}"

    //Room
    const val roomRoomRuntime = "androidx.room:room-runtime:${Versions.roomVersion}"
    const val roomRoomKtx = "androidx.room:room-ktx:${Versions.roomVersion}"
    const val roomRoomCompiler = "androidx.room:room-compiler:${Versions.roomVersion}"
    const val androidArchPersistenceRoomCompiler = "android.arch.persistence.room:compiler:${Versions.roomVersion}"
    const val roomRoomCommon = "androidx.room:room-common:${Versions.roomVersion}"

    //Coroutines
    const val kotlinCoroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.kotlinCoroutinesVersion}"
    const val kotlinCoroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlinCoroutinesVersion}"

    //Dagger hilt
    const val daggerHilt = "com.google.dagger:hilt-android:${Versions.daggerHiltVersion}"
    const val daggerHiltCompiler =
        "com.google.dagger:hilt-compiler:${Versions.daggerHiltVersion}"

    //Rx Java
    const val rxJava2RxAndroid = "io.reactivex.rxjava2:rxandroid:${Versions.rxJava2RxAndroidVersion}"
    const val rxJava3RxJava = "io.reactivex.rxjava3:rxjava:${Versions.rxJava3RxJavaVersion}"

    //Lifecycle
    const val lifecycleRuntimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleRuntimeKtxVersion}"
    const val lifecycleCommonJava8 = "androidx.lifecycle:lifecycle-common-java8:${Versions.lifecycleCommonJava8Version}"
    const val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycleExtensionsVersion}"

    const val lifecycle = "androidx.lifecycle:lifecycle-common-java8:${Versions.lifecycleVersion}"
    const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleVersion}"

    //Gson
    const val gsonGson = "com.google.code.gson:gson:${Versions.gsonGsonVersion}"

    //Navigation
    const val navigationFragment =
        "androidx.navigation:navigation-fragment-ktx:${Versions.navigationVersion}"
    const val navigationUI = "androidx.navigation:navigation-ui-ktx:${Versions.navigationVersion}"

    //Glide
    const val glideGlide = "com.github.bumptech.glide:glide:${Versions.glideVersion}"
    const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glideVersion}"

    //Ui
    const val coordinatorLayout = "androidx.coordinatorlayout:coordinatorlayout:${Versions.coordinatorLayoutVersion}"

    //Networking
    const val retrofit2Retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"
    const val retrofit2ConverterJson = "com.squareup.retrofit2:converter-gson:${Versions.retrofitVersion}"
    const val retrofit2AdapterRxjava2 = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofitVersion}"
    const val okhttpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttpLoggingInterceptorVersion}"
}