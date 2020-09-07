package com.example.muenje.adapters;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.muenje.LekcijaFragment;

public class LectionsContainerPagerAdapter extends FragmentStateAdapter {
    public static final int LECTION_1_PAGE_INDEX = 0;
    public static final int LECTION_2_PAGE_INDEX = 1;
    public static final int LECTION_3_PAGE_INDEX = 2;

    public LectionsContainerPagerAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Bundle bundle = new Bundle();
        bundle.putInt("page", position);
        Fragment fragment = new LekcijaFragment();
        fragment.setArguments(bundle);
        return fragment;
    }
}

