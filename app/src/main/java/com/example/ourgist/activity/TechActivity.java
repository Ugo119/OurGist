package com.example.ourgist.activity;

import androidx.fragment.app.Fragment;

import com.example.ourgist.controller.TechFragment;

public class TechActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {return new TechFragment(); }
}
