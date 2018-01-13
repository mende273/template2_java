package com.jumrukovski.template2.domain;


import com.jumrukovski.template2.data.model.Item;
import com.jumrukovski.template2.data.model.Result;
import com.jumrukovski.template2.data.repository.TvRepositoryImpl;
import com.jumrukovski.template2.injection.module.RxModule;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Scheduler;
import io.reactivex.Single;

public class GetTopRatedTvShowsUseCase extends BaseSingleUseCase<Result<List<Item>>> {

    private final TvRepositoryImpl repository;
    private final String apiKey;

    @Inject
    GetTopRatedTvShowsUseCase(TvRepositoryImpl repository, String apiKey,
                              @Named(RxModule.IO) Scheduler workScheduler,
                              @Named(RxModule.MAIN) Scheduler mainScheduler) {
        super(workScheduler, mainScheduler);
        this.repository = repository;
        this.apiKey = apiKey;
    }


    @Override
    Single<Result<List<Item>>> buildUseCaseObservable(String... params) {
        return repository.getTopRatedTvShows(apiKey, params[0], Integer.parseInt(params[1]));
    }
}
