package com.jumrukovski.template2.data.model;


import com.squareup.moshi.Json;

import java.util.List;

public class Item {

    @Json(name = "original_name")
    private String originalName;

    @Json(name = "name")
    private String name;

    @Json(name = "popularity")
    private float popularity;

    @Json(name = "vote_count")
    private long voteCount;

    @Json(name = "first_air_date")
    private String firstAirDate;

    @Json(name = "backdrop_path")
    private String backDropPath;

    @Json(name = "original_language")
    private String originalLanguage;

    @Json(name = "id")
    private long id;

    @Json(name = "vote_average")
    private float voteAverage;

    @Json(name = "overview")
    private String overview;

    @Json(name = "poster_path")
    private String posterPath;

    @Json(name = "genre_ids")
    private List<Integer> getnreIds;

    @Json(name = "origin_country")
    private List<String> originCountry;

    public String getOriginalName() {
        return originalName;
    }

    public String getName() {
        return name;
    }

    public float getPopularity() {
        return popularity;
    }

    public long getVoteCount() {
        return voteCount;
    }

    public String getFirstAirDate() {
        return firstAirDate;
    }

    public String getBackDropPath() {
        return backDropPath;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public long getId() {
        return id;
    }

    public float getVoteAverage() {
        return voteAverage;
    }

    public String getOverview() {
        return overview;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public List<Integer> getGetnreIds() {
        return getnreIds;
    }

    public List<String> getOriginCountry() {
        return originCountry;
    }
}
