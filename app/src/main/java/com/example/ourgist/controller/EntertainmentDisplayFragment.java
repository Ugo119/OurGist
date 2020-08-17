package com.example.ourgist.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.ourgist.R;
import com.example.ourgist.adapter.NewsCollectionPagerAdapter;

public class EntertainmentDisplayFragment extends Fragment {

    ImageView imageView;
    TextView title, date, author;
    WebView webView;
    FragmentManager fm;
    NewsCollectionPagerAdapter newsCollectionPagerAdapter;
    Intent intent;
    Bundle bundle;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news_display, container, false);

        webView = view.findViewById(R.id.news_content);

        fm = getActivity().getSupportFragmentManager();
        newsCollectionPagerAdapter = new NewsCollectionPagerAdapter(getContext(),fm);


        intent = getActivity().getIntent();
        bundle = intent.getBundleExtra("data");

        String entertainmentContent = bundle.getString("url");
        webView.loadUrl(entertainmentContent);

        return view;
    }

}
