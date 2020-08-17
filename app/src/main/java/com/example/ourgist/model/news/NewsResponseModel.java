package com.example.ourgist.model.news;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NewsResponseModel {
    @SerializedName("status")
    private String status;

    @SerializedName("totalResults")
    private int totalResults;

    @SerializedName("articles")
    private List<NaijNews> naijNews = null;

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

    public List<NaijNews> getNaijNews() {
        return naijNews;
    }
}
