package com.example.muenje.adapters;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.muenje.ui.lekcijafragment.LessonFragment;

public class LessonsContainerPagerAdapter extends FragmentStateAdapter {

    public LessonsContainerPagerAdapter(@NonNull Fragment fragment) {
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
        return LessonFragment.newInstance(bundle);
    }
}

