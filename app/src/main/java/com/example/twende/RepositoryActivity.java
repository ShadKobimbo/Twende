package com.example.twende;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import android.text.util.Linkify;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import android.content.res.ColorStateList;
import android.graphics.Color;

import com.example.twende.database.DBHelper;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class RepositoryActivity extends AppCompatActivity {

    static Context context = null;

    String repo_id, repo_name, repo_description, repo_forks, repo_stars, repo_watchers, repo_language, repo_created_at, repo_url;
    FloatingActionButton fab;
    
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repository);

        context = RepositoryActivity.this;
        DB = new DBHelper(this);

        fab = findViewById(R.id.floatingActionButtonActivity);

        getIncomingIntent();

        fab.setOnClickListener( view -> {
            addFavorite();
        });

    }

        private void getIncomingIntent() {

        if(getIntent().hasExtra("repo_name")){

            repo_id = getIntent().getStringExtra("repo_id");
            repo_name = getIntent().getStringExtra("repo_name");
            repo_description = getIntent().getStringExtra("repo_description");
            repo_forks = getIntent().getStringExtra("repo_forks");
            repo_stars = getIntent().getStringExtra("repo_stars");
            repo_watchers = getIntent().getStringExtra("repo_watchers");
            repo_language = getIntent().getStringExtra("repo_language");
            repo_created_at = getIntent().getStringExtra("repo_created_at");
            repo_url = getIntent().getStringExtra("repo_url");

            checkFavoriteStatus();

            setData(repo_id, repo_name, repo_description, repo_forks, repo_stars, repo_watchers, repo_language, repo_created_at, repo_url);

        }
    }

    private void checkFavoriteStatus() {

        //Check if Repo is in Favorites List
        boolean checkIfFavorite = DB.checkFavorites(repo_id);
        if(checkIfFavorite){
            fab.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFFFFFFF")));
            fab.setImageTintList(ColorStateList.valueOf(Color.parseColor("#D50000")));
        } else {
            fab.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#00ACC1")));
            fab.setImageTintList(ColorStateList.valueOf(Color.parseColor("#FFFFFFFF")));
        }
    }

    private void setData(String id, String repo_name, String repo_description, String repo_forks, String repo_stars, String repo_watchers, String repo_language, String repo_created_at, String repo_url) {

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

    public void addFavorite() {

        boolean checkFavoriteExists = DB.checkFavorites(repo_id);

        if(!checkFavoriteExists){

            boolean insertData = DB.insertIntoFavorites(repo_id, repo_name, repo_description);
            if(insertData){
                Toast.makeText(RepositoryActivity.this, "Repo Liked!", Toast.LENGTH_SHORT).show();
                fab.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFFFFFFF")));
                fab.setImageTintList(ColorStateList.valueOf(Color.parseColor("#D50000")));
            } else {
                Toast.makeText(RepositoryActivity.this, "Repo Has Not Been Liked!", Toast.LENGTH_SHORT).show();
            }
        }

        if(checkFavoriteExists) {
            boolean removeData = DB.removeFromFavorites(repo_id);
            if(removeData) {
                Toast.makeText(RepositoryActivity.this, "Repo UnLiked!", Toast.LENGTH_SHORT).show();
                fab.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#00ACC1")));
                fab.setImageTintList(ColorStateList.valueOf(Color.parseColor("#FFFFFFFF")));
            } else {
                Toast.makeText(RepositoryActivity.this, "Repo UnLiking Failed!", Toast.LENGTH_SHORT).show();
            }
        }
    }
}