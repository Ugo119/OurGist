package com.example.ourgist.model.sports;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SportsResponseModel {
    @SerializedName("status")
    private String status;

    @SerializedName("totalResults")
    private int totalResults;

    @SerializedName("articles")
    private List<SportsNews> mNews = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public List<SportsNews> getNews() {
        return mNews;
    }

    public void setNews(List<SportsNews> mNews) {
        this.mNews = mNews;
    }
}
