package com.jumrukovski.template2.data.repository;

import com.jumrukovski.template2.data.model.Item;
import com.jumrukovski.template2.data.model.Result;
import com.jumrukovski.template2.network.ApiService;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

public class TvRepositoryImpl implements TvRepository {

    private final ApiService service;

    @Inject
    TvRepositoryImpl(ApiService service, String apiKey) {
        this.service = service;
    }

    @Override
    public Single<Result<List<Item>>> getPopularTvShows(String apiKey, String language, int page) {
        return service.getPopularTvShows(apiKey, language, page)
                .flatMap(Single::just);
    }

    @Override
    public Single<Result<List<Item>>> getTopRatedTvShows(String apiKey, String language, int page) {
        return service.getTopRatedTvShows(apiKey, language, page)
                .flatMap(Single::just);
    }
}
