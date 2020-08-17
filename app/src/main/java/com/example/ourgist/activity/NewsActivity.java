package com.example.ourgist.activity;

import androidx.fragment.app.Fragment;

import com.example.ourgist.controller.NaijNewsFragment;

public class NewsActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {return new NaijNewsFragment();}
}
