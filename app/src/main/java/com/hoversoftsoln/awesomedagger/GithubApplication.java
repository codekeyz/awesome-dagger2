package com.hoversoftsoln.awesomedagger;

import android.app.Application;

import com.hoversoftsoln.awesomedagger.components.DaggerGithubApplicationComponent;
import com.hoversoftsoln.awesomedagger.components.GithubApplicationComponent;
import com.hoversoftsoln.awesomedagger.modules.ActivityModule;
import com.hoversoftsoln.awesomedagger.modules.ContextModule;

import timber.log.Timber;

public class GithubApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Timber.plant(new Timber.DebugTree());

        GithubApplicationComponent githubApplicationComponent = DaggerGithubApplicationComponent.builder()
                .contextModule(new ContextModule(this))
//                .networkModule(new NetworkModule())             // Dagger2  will automatically create this dependencies
//                .githubServiceModule(new GithubServiceModule())
                .build();


    }
}
