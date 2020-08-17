package com.example.ourgist.model.sports;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class SportsNews {
        @SerializedName("country")
        private SportsSourceModel country;

        @SerializedName("title")
        private String title;

        @SerializedName("description")
        private String description;

        @SerializedName("url")
        private String url;

        @SerializedName("urlToImage")
        private String urlToImage;

        @SerializedName("author")
        private String author;

        @SerializedName("publishedAt")
        private Date publishedAt;

        @SerializedName("content")
        private String content;

    public SportsSourceModel getCountry() {
        return country;
    }

    public void setCountry(SportsSourceModel country) {
        this.country = country;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(Date publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getContent() {
        return content;
    }
}
