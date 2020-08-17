package com.example.ourgist.activity;

import androidx.fragment.app.Fragment;

import com.example.ourgist.controller.SportsFragment;

public class SportsActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new SportsFragment();
    }
}
