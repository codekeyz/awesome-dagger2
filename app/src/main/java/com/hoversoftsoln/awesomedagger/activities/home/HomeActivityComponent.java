package com.hoversoftsoln.awesomedagger.activities.home;


import android.content.Context;

import dagger.Component;

@HomeActivityScope
@Component(modules = {HomeActivityModule.class})
public interface HomeActivityComponent {

    Context getContext();

}
