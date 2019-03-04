package com.hoversoftsoln.awesomedagger.modules;

import android.content.Context;

import com.google.gson.Gson;
import com.hoversoftsoln.awesomedagger.network.GithubService;
import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class GithubServiceModule {

    @Provides
    public GithubService githubService(Retrofit githubRetrofit) {
        return githubRetrofit.create(GithubService.class);
    }

    @Provides
    public Retrofit retrofit(OkHttpClient okHttpClient, Gson gson) {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .baseUrl("https://api.github.com/")
                .build();
    }

    @Provides
    public Picasso picasso(Context context, OkHttpClient okHttpClient) {
        return new Picasso.Builder(context)
                .downloader(new OkHttp3Downloader(okHttpClient))
                .build();
    }

}
