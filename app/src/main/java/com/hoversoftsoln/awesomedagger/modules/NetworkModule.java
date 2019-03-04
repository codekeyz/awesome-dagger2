package com.hoversoftsoln.awesomedagger.modules;

import android.content.Context;

import java.io.File;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import timber.log.Timber;

@Module
public class NetworkModule {

    @Provides
    public File cacheFile(Context context) {
        return new File(context.getCacheDir(), "okhttp_cache");
    }

    @Provides
    public Cache cache(File cacheFile) {
       return new Cache(cacheFile, 10 * 1000 * 1000); // 10MB Cache
    }

    @Provides
    public HttpLoggingInterceptor loggingInterceptor() {
        return new HttpLoggingInterceptor(message -> Timber.d(message));
    }

    @Provides
    public OkHttpClient okHttpClient(HttpLoggingInterceptor loggingInterceptor, Cache cache) {
        return new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .cache(cache)
                .build();
    }
}
