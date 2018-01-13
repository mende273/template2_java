package com.jumrukovski.template2.injection.module;

import android.app.Application;
import android.content.Context;

import com.jumrukovski.template2.MainActivityComponent;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(subcomponents = {
        MainActivityComponent.class})
public class AppModule {

    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }

    @Provides
    @Singleton
    String provideApiKey() {
        return "your_api_key_here";
    }
}
