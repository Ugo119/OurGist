package com.example.ourgist.rest;

import com.example.ourgist.model.business.BusinessResponseModel;
import com.example.ourgist.model.entertainment.EntertainmentResponseModel;
import com.example.ourgist.model.news.NewsResponseModel;
import com.example.ourgist.model.sports.SportsResponseModel;
import com.example.ourgist.model.technology.TechnologyResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsApiService {

    @GET("top-headlines")
    Call<SportsResponseModel> getSportsNews(@Query("country") String country,
                                         @Query("category") String category,
                                         @Query("apiKey") String apiKey);


    @GET("top-headlines")
    Call<NewsResponseModel> getNaijNews(@Query("country") String country,
                                        @Query("apiKey") String apiKey);

    @GET("top-headlines")
    Call<EntertainmentResponseModel> getEntertainmentNews(@Query("country") String country,
                                                          @Query("category") String category,
                                                          @Query("apiKey") String apiKey);

    @GET("top-headlines")
    Call<TechnologyResponseModel> getTechnologyNews(@Query("country") String country,
                                                    @Query("category") String category,
                                                    @Query("apiKey") String apiKey);

    @GET("top-headlines")
    Call<BusinessResponseModel> getBusinessNews(@Query("country") String country,
                                                @Query("category") String category,
                                                @Query("apiKey") String apiKey);
}
