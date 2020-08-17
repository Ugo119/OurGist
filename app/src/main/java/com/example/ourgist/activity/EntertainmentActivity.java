package com.example.ourgist.activity;

import androidx.fragment.app.Fragment;

import com.example.ourgist.controller.EntertainmentFragment;

public class EntertainmentActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {return new EntertainmentFragment(); }
}
