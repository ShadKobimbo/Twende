package com.example.twende.api;

import com.example.twende.model.Result;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GitHubAPIService {

    @GET("search/repositories?q=stars:>1&sort=stars")
    Call<Result> getRepoList();

}
