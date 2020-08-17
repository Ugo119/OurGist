package com.example.ourgist.controller;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ourgist.R;
import com.example.ourgist.activity.SportsDisplayActivity;
import com.example.ourgist.activity.SportsActivity;
import com.example.ourgist.adapter.sports.SportsNewsAdapter;
import com.example.ourgist.model.sports.SportsNews;
import com.example.ourgist.model.sports.SportsResponseModel;
import com.example.ourgist.rest.NewsApiService;
import com.example.ourgist.rest.RetrofitFactory;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SportsFragment extends Fragment {
    private static final String TAG = SportsActivity.class.getSimpleName();
    public String country = "ng";
    public String category = "sports";
    private static Retrofit retrofit;
    RecyclerView recyclerView;
    List<SportsNews> mNews;
    SportsNews news;
    SportsNewsAdapter adapter;
    private RecyclerView.LayoutManager mLayoutManager;

    // insert your themoviedb.org API KEY here
    private final static String API_KEY = RetrofitFactory.getApiKey();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sports, container, false);
        recyclerView = view.findViewById(R.id.news_recycler_view);
        mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(
                new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL));


        connectAndGetApiData();

        return view;
    }

    public void connectAndGetApiData() {
        retrofit = RetrofitFactory.getRetrofit();

        NewsApiService newsApiService = retrofit.create(NewsApiService.class);
        //Call<MovieResponse> call = movieApiService.getTopRatedMovies(API_KEY);

        Call<SportsResponseModel> call = newsApiService.getSportsNews(country, category, API_KEY);

        call.enqueue(new Callback<SportsResponseModel>() {
            @Override
            public void onResponse(Call<SportsResponseModel> call, Response<SportsResponseModel> response) {
                if (response.body().getStatus().equals("ok")) {
                    final List<SportsNews> news = response.body().getNews();
                    if (news.size() > 0) {
                        final SportsNewsAdapter adapter = new SportsNewsAdapter(getContext(), news);
                        recyclerView.setAdapter(adapter);
                        adapter.notifyDataSetChanged();

                        adapter.setOnItemClickListener(new SportsNewsAdapter.ClickListener() {
                            @Override
                            public void onItemClick(int position, View v) {
                                SportsNews sportsNews = new SportsNews();
                                Intent intent = new Intent(getContext(), SportsDisplayActivity.class);
                                Bundle bundle = new Bundle();
                                bundle.putString("NewsImage", news.get(position).getUrlToImage());
                                bundle.putString("NewsImage", news.get(position).getUrlToImage());
                                bundle.putString("url", news.get(position).getUrl());
                                bundle.putString("author", news.get(position).getAuthor());
                              //  bundle.putSerializable("date", sportsNews.getPublishedAt());


                                intent.putExtra("data", bundle);
                                startActivity(intent);
                                Log.d(TAG, "onItemClick position: " + position);
                            }

                        });
                    }

                }

            }

            @Override
            public void onFailure(Call<SportsResponseModel> call, Throwable t) {
                if (t instanceof IOException) {
                    Toast.makeText(getContext(), "this is an actual network failure " +
                            ":( inform the user and possibly retry", Toast.LENGTH_SHORT).show();
                    // logging probably not necessary
                } else {
                    Toast.makeText(getContext(), "conversion issue! big problems :(",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
