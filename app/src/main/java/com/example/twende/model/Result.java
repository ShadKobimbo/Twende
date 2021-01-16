package com.example.twende.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Result {

    @SerializedName("total_count")
    @Expose
    private String total_count;

    @SerializedName("incomplete_results")
    @Expose
    private String incomplete_results;

    @SerializedName("items")
    @Expose
    private List<Repo> repo;

    public Result(String total_count, String incomplete_results, List<Repo> repo) {

        this.total_count = total_count;
        this.incomplete_results = incomplete_results;
        this.repo = repo;

    }

    public String getTotal_count() {
        return total_count;
    }

    public void setTotal_count(String total_count) {
        this.total_count = total_count;
    }

    public String getIncomplete_results() {
        return incomplete_results;
    }

    public void setIncomplete_results(String incomplete_results) {
        this.incomplete_results = incomplete_results;
    }

    public List<Repo> getRepo() {
        return repo;
    }

    public void setRepo(List<Repo> repo) {
        this.repo = repo;
    }
}
