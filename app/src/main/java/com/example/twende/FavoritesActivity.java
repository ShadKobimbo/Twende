package com.example.twende;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.app.ProgressDialog;
import android.os.Bundle;

import com.example.twende.adapters.recyclerview.FavoritesAdapter;
import com.example.twende.adapters.recyclerview.RepoAdapter;
import com.example.twende.database.DBHelper;
import com.example.twende.model.FavoritesModel;

import java.util.ArrayList;

public class FavoritesActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    ArrayList<FavoritesModel> favoritesArrayList;
    private FavoritesAdapter favoritesAdapter;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);

        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.favoritesSwipeContainer);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                initView("refresh");
            }
        });

        initView("regular");

        fetchFavoritesData();

    }

    private void fetchFavoritesData() {

        DBHelper dbHelper = new DBHelper(this);

        favoritesArrayList = new ArrayList<>(dbHelper.readFavoritesData());

        if(favoritesArrayList != null){
            favoritesAdapter = new FavoritesAdapter(this, favoritesArrayList);
            recyclerView.setAdapter(favoritesAdapter);
            progressDialog.hide();
        }
    }

    private void initView(String status) {

        if(status == "refresh"){
            recyclerView = findViewById(R.id.rv_local_repositories);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            mSwipeRefreshLayout.setRefreshing(false);
        } else {
            progressDialog = new ProgressDialog(this);
            progressDialog.setMessage("Fetching Favorites Data...");
            progressDialog.setCancelable(false);
            progressDialog.show();

            recyclerView = findViewById(R.id.rv_local_repositories);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        }
    }
}