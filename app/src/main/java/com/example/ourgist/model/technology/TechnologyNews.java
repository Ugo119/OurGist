package com.example.ourgist.model.technology;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class TechnologyNews {

    @SerializedName("author")
    private String author;

    @SerializedName("title")
    private String title;

    @SerializedName("description")
    private String description;

    @SerializedName("url")
    private String url;

    @SerializedName("urlToImage")
    private String urlToImage;

    @SerializedName("publishedAt")
    private Date publishedAt;

    @SerializedName("country")
    private TechnologySourceModel country;

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public Date getPublishedAt() {
        return publishedAt;
    }

    public TechnologySourceModel getCountry() {
        return country;
    }
}
