package com.hoversoftsoln.awesomedagger.activities.home;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

public class HomeActivity extends AppCompatActivity {

    @Inject
    Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DaggerHomeActivityComponent.builder()
                .homeActivityModule(new HomeActivityModule(this))
                .build();
    }
}
