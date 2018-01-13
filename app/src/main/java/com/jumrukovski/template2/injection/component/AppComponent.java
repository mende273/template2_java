package com.jumrukovski.template2.injection.component;

import android.app.Application;

import com.jumrukovski.template2.App;
import com.jumrukovski.template2.injection.builders.ActivityBuilder;
import com.jumrukovski.template2.injection.module.AppModule;
import com.jumrukovski.template2.injection.module.RetrofitModule;
import com.jumrukovski.template2.injection.module.RxModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Singleton
@Component(modules = {
        AndroidInjectionModule.class,
        AppModule.class,
        ActivityBuilder.class,
        RetrofitModule.class,
        RxModule.class})
public interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }

    void inject(App app);
}
