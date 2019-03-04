package com.hoversoftsoln.awesomedagger.modules;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hoversoftsoln.awesomedagger.scopes.GithubApplicationScope;
import com.squareup.picasso.OkHttp3Downloader;

import java.io.File;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import timber.log.Timber;

@Module(includes = {ContextModule.class})
public class NetworkModule {

    @Provides
    @GithubApplicationScope
    public File cacheFile(Context context) {
        return new File(context.getCacheDir(), "okhttp_cache");
    }

    @Provides
    @GithubApplicationScope
    public Cache cache(File cacheFile) {
       return new Cache(cacheFile, 10 * 1000 * 1000); // 10MB Cache
    }

    @Provides
    @GithubApplicationScope
    public HttpLoggingInterceptor loggingInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(message -> Timber.i(message));
        interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        return interceptor;
    }

    @Provides
    @GithubApplicationScope
    public OkHttpClient okHttpClient(HttpLoggingInterceptor loggingInterceptor, Cache cache) {
        return new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .cache(cache)
                .build();
    }

    @Provides
    @GithubApplicationScope
    public OkHttp3Downloader okHttp3Downloader(OkHttpClient okHttpClient) {
        return new OkHttp3Downloader(okHttpClient);
    }

    @Provides
    @GithubApplicationScope
    public Gson gson() {
       return new GsonBuilder().create();
    }
}
