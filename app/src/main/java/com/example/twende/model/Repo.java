package com.example.twende.model;

public class Repo {

    private String name;
    private String description;
    private String stars;
    private String watchers;
    private String forks;


    public Repo(String name, String description, String stars, String watchers, String forks) {

        this.name = name;
        this.description = description;
        this.stars = stars;
        this.watchers = watchers;
        this.forks = forks;

    }

    public String getName() {
        return name;
    }

    public void set_name(String name) {
        this.name = name;
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

}
