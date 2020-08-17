package com.example.ourgist.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.ourgist.R;
import com.example.ourgist.controller.BizFragment;
import com.example.ourgist.controller.EntertainmentFragment;
import com.example.ourgist.controller.NaijNewsFragment;
import com.example.ourgist.controller.SportsFragment;
import com.example.ourgist.controller.TechFragment;

public class NewsCollectionPagerAdapter extends FragmentStatePagerAdapter {
    private Context mContext;
    public NewsCollectionPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    public NewsCollectionPagerAdapter(Context context, FragmentManager fm){
        super(fm);
        mContext = context;

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new NaijNewsFragment();
        } else if (position == 1) {
            return new SportsFragment();
        } else if (position == 2) {
            return new TechFragment();
        } else if(position == 3){
            return new BizFragment();
        }else{return new EntertainmentFragment();
        }
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.naija_news);
        } else if (position == 1) {
            return mContext.getString(R.string.sports_news);
        } else if (position == 2) {
            return mContext.getString(R.string.tech_news);
        } else if(position == 3) {
            return mContext.getString(R.string.biz_news);
        }else{return mContext.getString(R.string.entertainment_news);}
    }
}
