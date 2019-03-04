package com.hoversoftsoln.awesomedagger.modules;

import android.app.Activity;
import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    private final Context context;

    public ActivityModule(Activity activity) {
        this.context = activity.getApplicationContext();
    }

    @Provides
    public Context context() {
        return context;
    }
}
