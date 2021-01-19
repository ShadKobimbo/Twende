package com.example.twende;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.twende.adapters.recyclerview.RepoAdapter;
import com.example.twende.api.GitHubAPIService;
import com.example.twende.api.RestApiBuilder;
import com.example.twende.model.Repo;
import com.example.twende.model.Result;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recycler;
    private RepoAdapter repoAdapter;

    public static List<Repo> reposArrayList;
    private ConstraintLayout constraintLayout;

    static Context context = null;

    ProgressDialog pd;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        constraintLayout = (ConstraintLayout) findViewById(R.id.main_constraint_layout);
        context = MainActivity.this;

        initView();

        fetchRepoData();

    }

    private void fetchRepoData() {

        GitHubAPIService apiService = new RestApiBuilder().getService();
        Call<Result> repoListCall = apiService.getRepoList();

        repoListCall.enqueue(new Callback<Result>() {

            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                if(response.isSuccessful()) {
                    reposArrayList = response.body().getRepo();
                    initRecyclerView(reposArrayList);
                    pd.hide();
                } else {

                    Toast.makeText(MainActivity.this,
                            "Request not Successful",
                            Toast.LENGTH_SHORT).show();
                    pd.hide();
                }
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                Toast.makeText(MainActivity.this,
                        t.getMessage(),
                        Toast.LENGTH_SHORT).show();
                Log.e("Hapa Ndio Ngori Iko", t.getMessage());
            }
        });
    }

    private void initView() {

        pd = new ProgressDialog(this);
        pd.setMessage("Fetching Github Data...");
        pd.setCancelable(false);
        pd.show();

        recycler = findViewById(R.id.rv_top_repositories);
        recycler.setLayoutManager(new LinearLayoutManager(this));
    }

    public void initRecyclerView(List setter) {

        repoAdapter = new RepoAdapter(this, setter);
        recycler.setAdapter(repoAdapter);

    }

    public static void onItemClick(String id, String name, String description, String forks, String stars, String watchers, String language, String created_at, String html_url) {

        Intent intent = new Intent(context, RepositoryActivity.class);

        intent.putExtra("repo_id", id);
        intent.putExtra("repo_name", name);
        intent.putExtra("repo_description", description);
        intent.putExtra("repo_forks", forks);
        intent.putExtra("repo_stars", stars);
        intent.putExtra("repo_watchers", watchers);
        intent.putExtra("repo_language", language);
        intent.putExtra("repo_created_at", created_at);
        intent.putExtra("repo_url", html_url);

        context.startActivity(intent);
    }
}