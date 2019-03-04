package com.hoversoftsoln.awesomedagger.components;

import com.hoversoftsoln.awesomedagger.modules.GithubServiceModule;
import com.hoversoftsoln.awesomedagger.network.GithubService;
import com.squareup.picasso.Picasso;

import dagger.Component;

@Component(modules = GithubServiceModule.class)
public interface GithubApplicationComponent {

    Picasso getPicasso();

    GithubService getGithubService();

}
