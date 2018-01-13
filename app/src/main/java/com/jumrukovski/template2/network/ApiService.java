package com.jumrukovski.template2.network;


import com.jumrukovski.template2.data.model.Item;
import com.jumrukovski.template2.data.model.Result;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    String ENDPOINT = "http://api.themoviedb.org/3/";

    @GET("tv/popular/")
    Single<Result<List<Item>>> getPopularTvShows(@Query("api_key") String apiKey, @Query("language") String language, @Query("page") int page);

    @GET("tv/top_rated")
    Single<Result<List<Item>>> getTopRatedTvShows(@Query("api_key") String apiKey, @Query("language") String language, @Query("page") int page);
}
