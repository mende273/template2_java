package com.jumrukovski.template2.injection.builders;

import com.jumrukovski.template2.MainActivity;
import com.jumrukovski.template2.MainActivityModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {

    // we add all our activities here

    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity bindMainActivity();
}
