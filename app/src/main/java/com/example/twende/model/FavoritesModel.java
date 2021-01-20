package com.example.twende.model;

public class FavoritesModel {

    private String repo_id;
    private String repo_name;
    private String repo_description;

    public FavoritesModel(String repo_id, String repo_name, String repo_description) {

        this.repo_id = repo_id;
        this.repo_name = repo_name;
        this.repo_description = repo_description;

    }

    public String getRepo_id() {
        return repo_id;
    }

    public void setRepo_id(String repo_id) {
        this.repo_id = repo_id;
    }

    public String getRepo_name() {
        return repo_name;
    }

    public void setRepo_name(String repo_name) {
        this.repo_name = repo_name;
    }

    public String getRepo_description() {
        return repo_description;
    }

    public void setRepo_description(String repo_description) {
        this.repo_description = repo_description;
    }
}
