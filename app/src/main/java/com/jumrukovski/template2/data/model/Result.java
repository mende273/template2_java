package com.jumrukovski.template2.data.model;


import com.google.gson.annotations.SerializedName;

public class Result<T> {

    @SerializedName("page")
    private int page;

    @SerializedName("total_results")
    private int totalResults;

    @SerializedName("total_pages")
    private int totalPages;

    @SerializedName("results")
    private T results;

    public int getPage() {
        return page;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public T getResults() {
        return results;
    }

    @Override
    public String toString() {
        return "Result{" +
                "page=" + page +
                ", totalResults=" + totalResults +
                ", totalPages=" + totalPages +
                ", results=" + results +
                '}';
    }
}
