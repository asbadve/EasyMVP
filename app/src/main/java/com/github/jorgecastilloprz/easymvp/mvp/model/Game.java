package com.github.jorgecastilloprz.easymvp.mvp.model;

import java.util.ArrayList;

/**
 * Application game model
 * Created by jorge on 18/01/15.
 */
public class Game {
    
    private String name;
    private String image;
    private String summary;
    private String description;
    private String releaseDate;
    private ArrayList<String> platforms;

    public Game(String name, String image, String summary, String description, String releaseDate, ArrayList<String> platforms) {
        this.name = name;
        this.image = image;
        this.summary = summary;
        this.description = description;
        this.releaseDate = releaseDate;
        this.platforms = platforms;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public ArrayList<String> getPlatforms() {
        return platforms;
    }

    public void setPlatforms(ArrayList<String> platforms) {
        this.platforms = platforms;
    }
}
