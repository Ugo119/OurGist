package com.example.ourgist.rest;

import com.example.ourgist.model.sports.SportsNews;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitFactory {
    static SportsNews news = new SportsNews();
    private static final String BASE_URL = "https://newsapi.org/v2/";
 //  private static final String IMAGE_URL_BASE_PATH = news.getUrlToImage();
    private static final String API_KEY = "9f37150adacb4632843bf3af3378c539";

    public RetrofitFactory(){}
    public static Retrofit getRetrofit(){
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();

        //.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(getBaseUrl())
                .addConverterFactory(GsonConverterFactory.create())
                //.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client);
        Retrofit retrofit = builder.build();

        return retrofit;
    }


    public static String getApiKey(){
        return API_KEY;
    }

    public static String getBaseUrl(){
        return BASE_URL;
    }

   // public static String getImageUrlBasePath(){
       // return IMAGE_URL_BASE_PATH;
  //  }



}
