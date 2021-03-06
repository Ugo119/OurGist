package com.example.ourgist.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.ourgist.adapter.NewsCollectionPagerAdapter;
import com.example.ourgist.controller.SportsDisplayFragment;
import com.example.ourgist.controller.SportsFragment;

public class SportsDisplayActivity extends SingleFragmentActivity {
    NewsCollectionPagerAdapter newsCollectionPagerAdapter;
    Bundle bundle;

    @Override
    protected Fragment createFragment() {
        FragmentManager fm = getSupportFragmentManager();
        SportsFragment sportsFragment = new SportsFragment();
        Intent intent = getIntent();
        bundle = intent.getBundleExtra("data");

        fm = getSupportFragmentManager();
        newsCollectionPagerAdapter = new NewsCollectionPagerAdapter(this, fm);

         return new SportsDisplayFragment();




    }
}
