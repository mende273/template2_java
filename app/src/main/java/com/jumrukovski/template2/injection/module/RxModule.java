package com.jumrukovski.template2.injection.module;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@SuppressWarnings("WeakerAccess")
@Module
public class RxModule {

    public static final String MAIN = "main";
    public static final String IO = "io";
    public static final String COMPUTATION = "computation";

    @Provides
    @Singleton
    @Named(MAIN)
    public Scheduler provideMainScheduler() {
        return AndroidSchedulers.mainThread();
    }

    @Provides
    @Singleton
    @Named(IO)
    public Scheduler provideIoScheduler() {
        return Schedulers.io();
    }

    @Provides
    @Singleton
    @Named(COMPUTATION)
    public Scheduler provideComputationScheduler() {
        return Schedulers.computation();
    }
}
