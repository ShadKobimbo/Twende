package com.example.twende;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.twende.adapters.recyclerview.RepoAdapter;
import com.example.twende.api.GitHubAPIService;
import com.example.twende.api.RestApiBuilder;
import com.example.twende.model.Repo;
import com.example.twende.network.CheckNetwork;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recycler;
    private RepoAdapter repoAdapter;

    public static ArrayList<Repo> reposArrayList = new ArrayList<Repo>();
    private ConstraintLayout constraintLayout;

//    Boolean isConnected = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        constraintLayout = (ConstraintLayout) findViewById(R.id.main_constraint_layout);

        initView();

        // Register Callback - Call this in your app start!
        CheckNetwork network = new CheckNetwork(getApplicationContext());
        network.registerNetworkCallback();

        // Check network connection
        if (network.registerNetworkCallback()){
            // Internet Connected
            fetchUsersData();

        }else{
            // Not Connected
            Toast.makeText(MainActivity.this,
                    "Check your internet connection!!!",
                    Toast.LENGTH_SHORT).show();
        }
    }

    private void fetchUsersData() {

        String searchParams = "stars:>1 sort=stars";
        GitHubAPIService apiService = new RestApiBuilder().getService();
        Call<Repo> repoListCall = apiService.getRepoList(searchParams);

        repoListCall.enqueue(new Callback<Repo>() {

            @Override
            public void onResponse(Call<Repo> call, Response<Repo> response) {
                if (response.isSuccessful()) {
                    reposArrayList = response.body();
                    initRecyclerView(reposArrayList);
                } else {

                    Toast.makeText(MainActivity.this,
                            "Request not Successful",
                            Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Repo> call, Throwable t) {
                Toast.makeText(MainActivity.this,
                        "Request failed....",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initView() {

        recycler = findViewById(R.id.rv_top_repositories);
        recycler.setLayoutManager(new LinearLayoutManager(this));
    }

    public void initRecyclerView(ArrayList setter) {

        reposArrayList = setter;

        repoAdapter = new RepoAdapter(this, reposArrayList);
        recycler.setAdapter(repoAdapter);

    }
}