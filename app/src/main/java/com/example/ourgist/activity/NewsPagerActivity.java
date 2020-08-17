package com.example.ourgist.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.ourgist.R;
import com.example.ourgist.adapter.NewsCollectionPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class NewsPagerActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    NewsCollectionPagerAdapter newsCollectionPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_pager);
        // Create an adapter that knows which fragment should be shown on each page
        newsCollectionPagerAdapter = new NewsCollectionPagerAdapter(this, getSupportFragmentManager());

        // Find the tab layout that shows the tabs
        TabLayout tabLayout = findViewById(R.id.tab_layout);

        // Connect the tab layout with the view pager. This will
        //   1. Update the tab layout when the view pager is swiped
        //   2. Update the view pager when a tab is selected
        //   3. Set the tab layout's tab names with the view pager's adapter's titles
        //      by calling onPageTitle()
        tabLayout.setupWithViewPager(mViewPager);

        // Find the view pager that will allow the user to swipe between fragments
        mViewPager = findViewById(R.id.news_view_pager);

        // Set the adapter onto the view pager
        mViewPager.setAdapter(newsCollectionPagerAdapter);




    }
}