package com.example.twende.api;

import com.example.twende.model.Repo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GitHubAPIService {

    @GET("/search/repositories")
    Call<Repo> getRepoList(@Query("q") String filter);

}
