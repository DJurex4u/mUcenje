package com.example.muenje.ui.lekcijafragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.muenje.R;

public class LessonFragment extends Fragment {

    private Integer mPosition;


    public static LessonFragment newInstance(Bundle args) {
        LessonFragment fragment = new LessonFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPosition = this.getArguments().getInt("page");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_lekcija, container, false);
    }
}