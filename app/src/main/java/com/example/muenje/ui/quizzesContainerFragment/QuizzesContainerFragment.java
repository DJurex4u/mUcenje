package com.example.muenje.ui.quizzesContainerFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.muenje.adapters.QuizContainerPagerAdapter;
import com.example.muenje.databinding.FragmentIzazoviContainerBinding;


public class QuizzesContainerFragment extends Fragment {
    FragmentIzazoviContainerBinding mBinding;
    QuizContainerPagerAdapter mAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); 
        mAdapter = new QuizContainerPagerAdapter(this);


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = FragmentIzazoviContainerBinding.inflate(inflater, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBinding.viewPager2.setAdapter(mAdapter);
    }
}