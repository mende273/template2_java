package com.jumrukovski.template2.data.model;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Item {

    @SerializedName("original_name")
    private String originalName;

    @SerializedName("name")
    private String name;

    @SerializedName("popularity")
    private float popularity;

    @SerializedName("vote_count")
    private long voteCount;

    @SerializedName("first_air_date")
    private String firstAirDate;

    @SerializedName("backdrop_path")
    private String backDropPath;

    @SerializedName("original_language")
    private String originalLanguage;

    @SerializedName("id")
    private long id;

    @SerializedName("vote_average")
    private float voteAverage;

    @SerializedName("overview")
    private String overview;

    @SerializedName("poster_path")
    private String posterPath;

    @SerializedName("genre_ids")
    private List<Integer> getnreIds;

    @SerializedName("origin_country")
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

    @Override
    public String toString() {
        return "Item{" +
                "originalName='" + originalName + '\'' +
                ", name='" + name + '\'' +
                ", popularity=" + popularity +
                ", voteCount=" + voteCount +
                ", firstAirDate='" + firstAirDate + '\'' +
                ", backDropPath='" + backDropPath + '\'' +
                ", originalLanguage='" + originalLanguage + '\'' +
                ", id=" + id +
                ", voteAverage=" + voteAverage +
                ", overview='" + overview + '\'' +
                ", posterPath='" + posterPath + '\'' +
                ", getnreIds=" + getnreIds +
                ", originCountry=" + originCountry +
                '}';
    }
}
