package com.altran.ibanarriola.gnomestown.injection;

import com.altran.ibanarriola.gnomestown.view.activity.GnomeListActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class InjectorBuilder {

    @ContributesAndroidInjector(modules = GnomeListModule.class)
    @PerActivity
    abstract GnomeListActivity contributeGnomeListActivity();
}
