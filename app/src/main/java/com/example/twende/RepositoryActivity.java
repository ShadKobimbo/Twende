package com.example.twende;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class RepositoryActivity extends AppCompatActivity {

    static Context context = null;

    String repo_name, repo_description, repo_forks, repo_stars, repo_watchers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repository);

        context = RepositoryActivity.this;

        getIncomingIntent();

    }

    private void getIncomingIntent() {

        if(getIntent().hasExtra("repo_name")){

            repo_name = getIntent().getStringExtra("repo_name");
            repo_description = getIntent().getStringExtra("repo_description");
            repo_forks = getIntent().getStringExtra("repo_forks");
            repo_stars = getIntent().getStringExtra("repo_stars");
            repo_watchers = getIntent().getStringExtra("repo_watchers");

            setData(repo_name, repo_description, repo_forks, repo_stars, repo_watchers);

        }
    }

    private void setData(String repo_name, String repo_description, String repo_forks, String repo_stars, String repo_watchers) {

        TextView name = findViewById(R.id.tv_name);
        TextView description = findViewById(R.id.tv_description);
        TextView forks = findViewById(R.id.tv_forks);
        TextView stars = findViewById(R.id.tv_stars);
        TextView watchers = findViewById(R.id.tv_watchers);


        name.setText(repo_name);
        description.setText(repo_description);
        forks.setText(repo_forks);
        stars.setText(repo_watchers);
        watchers.setText(repo_watchers);

    }
}