package com.example.muenje.ui.loginfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.muenje.databinding.FragmentLoginBinding;

public class LoginFragment extends Fragment {
    FragmentLoginBinding mBinding = null;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    mBinding = FragmentLoginBinding.inflate(inflater, container, false);
    return mBinding.getRoot();
    }
}