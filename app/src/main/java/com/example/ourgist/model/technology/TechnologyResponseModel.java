package com.example.ourgist.model.technology;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TechnologyResponseModel {
    @SerializedName("status")
    private String status;

    @SerializedName("totalResults")
    private int totalResults;

    @SerializedName("articles")
    private List<TechnologyNews> techNews = null;

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

    public List<TechnologyNews> getTechNews() {
        return techNews;
    }


}
