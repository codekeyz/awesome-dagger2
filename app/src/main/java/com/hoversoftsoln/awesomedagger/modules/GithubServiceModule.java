package com.hoversoftsoln.awesomedagger.modules;

import android.content.Context;

import com.google.gson.Gson;
import com.hoversoftsoln.awesomedagger.network.GithubService;
import com.hoversoftsoln.awesomedagger.scopes.GithubApplicationScope;
import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = {NetworkModule.class})
public class GithubServiceModule {

    @Provides
    @GithubApplicationScope
    public GithubService githubService(Retrofit githubRetrofit) {
        return githubRetrofit.create(GithubService.class);
    }

    @Provides
    @GithubApplicationScope
    public Retrofit retrofit(OkHttpClient okHttpClient, Gson gson) {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .baseUrl("https://api.github.com/")
                .build();
    }

    @Provides
    @GithubApplicationScope
    public Picasso picasso(Context context, OkHttp3Downloader downloader) {
        return new Picasso.Builder(context)
                .downloader(downloader)
                .build();
    }

}
