package com.example.muenje.adapters;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.muenje.ui.quizzesContainerFragment.quizFragment.QuizFragment;

public class QuizContainerPagerAdapter extends FragmentStateAdapter {

    public QuizContainerPagerAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Bundle bundle = new Bundle();
        bundle.putInt("page", position);
        return QuizFragment.newInstance(bundle);
    }

    @Override
    public int getItemCount() {
        return  3;
    }
}
