package com.jumrukovski.template2;

import android.app.Activity;

import com.jumrukovski.template2.injection.scope.PerActivity;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class MainActivityModule {

    @Binds
    @PerActivity
    abstract Activity activity(MainActivity mainActivity);
}
