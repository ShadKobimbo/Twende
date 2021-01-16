package com.example.twende;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;

import android.text.util.Linkify;
import android.widget.TextView;

public class RepositoryActivity extends AppCompatActivity {

    static Context context = null;

    String repo_name, repo_description, repo_forks, repo_stars, repo_watchers, repo_language, repo_created_at, repo_url;

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
            repo_language = getIntent().getStringExtra("repo_language");
            repo_created_at = getIntent().getStringExtra("repo_created_at");
            repo_url = getIntent().getStringExtra("repo_url");

            setData(repo_name, repo_description, repo_forks, repo_stars, repo_watchers, repo_language, repo_created_at, repo_url);

        }
    }

    private void setData(String repo_name, String repo_description, String repo_forks, String repo_stars, String repo_watchers, String repo_language, String repo_created_at, String repo_url) {

        TextView name = findViewById(R.id.tv_name);
        TextView description = findViewById(R.id.tv_description);
        TextView forks = findViewById(R.id.tv_forks);
        TextView stars = findViewById(R.id.tv_stars);
        TextView watchers = findViewById(R.id.tv_watchers);
        TextView language = findViewById(R.id.tv_language);
        TextView created_at = findViewById(R.id.tv_creation_date);
        TextView url = findViewById(R.id.tv_url);

        name.setText(repo_name);
        description.setText(repo_description);
        forks.setText(repo_forks);
        stars.setText(repo_watchers);
        watchers.setText(repo_watchers);

        language.setText(repo_language);
        created_at.setText(repo_created_at);

        url.setText(repo_url);
        Linkify.addLinks(url, Linkify.WEB_URLS);
    }
}