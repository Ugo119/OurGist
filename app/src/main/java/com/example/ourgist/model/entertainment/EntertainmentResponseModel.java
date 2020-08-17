package com.example.ourgist.model.entertainment;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EntertainmentResponseModel {
    @SerializedName("status")
    private String status;

    @SerializedName("totalResults")
    private int totalResults;

    @SerializedName("articles")
    private List<EntertainmentNews> entertainmentNews = null;

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

    public List<EntertainmentNews> getEntertainmentNews() {
        return entertainmentNews;
    }
}
