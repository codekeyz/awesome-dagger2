package com.hoversoftsoln.awesomedagger.modules;

import android.content.Context;

import com.hoversoftsoln.awesomedagger.qualifiers.ApplicationContext;
import com.hoversoftsoln.awesomedagger.scopes.GithubApplicationScope;

import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {

    private final Context context;

    public ContextModule(Context context) {
        this.context = context.getApplicationContext();
    }

    @Provides
    @GithubApplicationScope
    @ApplicationContext
    public Context context() {
        return context;
    }
}
