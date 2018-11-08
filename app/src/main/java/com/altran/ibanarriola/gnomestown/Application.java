package com.altran.ibanarriola.gnomestown;

import com.altran.ibanarriola.gnomestown.injection.ApplicationComponent;
import com.altran.ibanarriola.gnomestown.injection.DaggerApplicationComponent;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;

public class Application extends DaggerApplication {

    protected ApplicationComponent applicationComponent;

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        applicationComponent = DaggerApplicationComponent.builder().application(this).build();
        applicationComponent.inject(this);
        return applicationComponent;
    }

    public ApplicationComponent getAplicationComponent() {
        return applicationComponent;
    }
}

