package com.jumrukovski.template2.data.model;


import com.squareup.moshi.Json;

public class Result<T> {

    @Json(name = "page")
    private int page;

    @Json(name = "total_results")
    private int totalResults;

    @Json(name = "total_pages")
    private int totalPages;

    @Json(name = "results")
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
}
