package com.example.muenje.adapters;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.muenje.ui.lekcijaFragment.LekcijaFragment;

public class LectionsContainerPagerAdapter extends FragmentStateAdapter {

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
        return LekcijaFragment.newInstance(bundle);
    }
}

