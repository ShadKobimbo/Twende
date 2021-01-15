package com.example.twende.model;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.stream.Stream;

public class Repo extends ArrayList<Repo> {

    private String repo_name;
    private String description;
    private String stars;
    private String watchers;
    private String forks;


    public Repo(String repo_name, String description, String stars, String watchers, String forks) {

        this.repo_name = repo_name;
        this.description = description;
        this.description = stars;
        this.description = watchers;
        this.description = forks;

    }

    public String getRepo_name() {
        return repo_name;
    }

    public void setRepo_name(String repo_name) {
        this.repo_name = repo_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStars() {
        return stars;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }

    public String getWatchers() {
        return watchers;
    }

    public void setWatchers(String watchers) {
        this.watchers = watchers;
    }

    public String getForks() {
        return forks;
    }

    public void setForks(String forks) {
        this.forks = forks;
    }

    @NonNull
    @Override
    public Stream<Repo> stream() {
        return null;
    }
}
