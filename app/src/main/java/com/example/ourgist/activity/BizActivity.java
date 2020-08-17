package com.example.ourgist.activity;

import androidx.fragment.app.Fragment;

import com.example.ourgist.controller.BizFragment;

public class BizActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {return new BizFragment();}
}
