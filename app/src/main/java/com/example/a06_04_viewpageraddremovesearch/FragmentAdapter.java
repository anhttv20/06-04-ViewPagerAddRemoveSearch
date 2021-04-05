package com.example.a06_04_viewpageraddremovesearch;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class FragmentAdapter extends FragmentPagerAdapter {
    private int num_pages = 2;
    private AddFragment addFragment;
    private SearchAdapter searchAdapter;

    public FragmentAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new AddFragment();
            case 1:
                return new SearchFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return num_pages;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0 :
                return "Add and Remove";
            case 1 :
                return "Searching";
        }
        return null;
    }
}
