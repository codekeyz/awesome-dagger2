package com.hoversoftsoln.awesomedagger.components;

import com.hoversoftsoln.awesomedagger.modules.GithubServiceModule;
import com.hoversoftsoln.awesomedagger.network.GithubService;
import com.hoversoftsoln.awesomedagger.scopes.GithubApplicationScope;
import com.squareup.picasso.Picasso;

import dagger.Component;

@GithubApplicationScope
@Component(modules = {GithubServiceModule.class})
public interface GithubApplicationComponent {

    Picasso getPicasso();

    GithubService getGithubService();

}
