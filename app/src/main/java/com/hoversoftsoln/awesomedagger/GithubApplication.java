package com.hoversoftsoln.awesomedagger;

import android.app.Application;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import timber.log.Timber;

public class GithubApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();

        Timber.plant(new Timber.DebugTree());
    }
}
