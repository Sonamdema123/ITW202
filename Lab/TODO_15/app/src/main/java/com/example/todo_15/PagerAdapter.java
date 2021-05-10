package com.example.todo_15;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {
    int mNumOfTabs;

    public PagerAdapter(@NonNull FragmentManager fm, int behaviour){ super(fm, behaviour); }

    @NonNull
    @Override
    public Fragment getItem(int position){
        switch (position){
            case 0: return new Fragment_tab1();
            case 1: return new Fragment_tab2();
            case 2:return new Fragment_tab3();
            default:return null;
        }
    }
    @Override
    public int getCount(){return mNumOfTabs; }
}
