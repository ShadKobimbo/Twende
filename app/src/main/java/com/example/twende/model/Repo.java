package com.example.twende.model;

public class Repo {

    private String id;
    private String name;
    private String description;
    private String stars;
    private String watchers;
    private String forks;
    private String language;
    private String created_at;
    private String html_url;



    public Repo(String id, String name, String description, String stars, String watchers, String forks, String language, String created_at, String html_url) {

        this.id = id;
        this.name = name;
        this.description = description;
        this.stars = stars;
        this.watchers = watchers;
        this.forks = forks;
        this.language = language;
        this.created_at = created_at;
        this.html_url = html_url;

    }

    public String getId() {
        return id;
    }

    public void set_id(String id) {
        this.id = id;
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

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getHtml_url() {
        return html_url;
    }

    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }
}
