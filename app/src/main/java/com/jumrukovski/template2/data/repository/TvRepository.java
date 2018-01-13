package com.jumrukovski.template2.data.repository;


import io.reactivex.Single;

public interface TvRepository {

    Single getPopularTvShows(String apiKey, String language, int page);

    Single getTopRatedTvShows(String apiKey, String language, int page);
}
