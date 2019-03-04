package com.hoversoftsoln.awesomedagger.activities.home;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module()
public class HomeActivityModule {

    private final HomeActivity homeActivity;

    public HomeActivityModule(HomeActivity homeActivity) {
        this.homeActivity = homeActivity;
    }

    @Provides
    Context context() {
        return homeActivity.getApplicationContext();
    }
}
