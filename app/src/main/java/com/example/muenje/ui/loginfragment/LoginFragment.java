package com.example.muenje.ui.loginfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.muenje.BaseApplication;
import com.example.muenje.data.interactor.LoginInteractor;
import com.example.muenje.databinding.FragmentLoginBinding;
import com.example.muenje.routers.LoginRouter;


public class LoginFragment extends Fragment {
    FragmentLoginBinding mBinding;
    LoginViewModel mViewModel;
    LoginRouter mLoginRouter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BaseApplication application = ((BaseApplication) requireActivity().getApplication());
        mViewModel = new ViewModelProvider(requireActivity()).get(LoginViewModel.class);
        LoginInteractor loginInteractor = new LoginInteractor(application.getRxFirebaseHelperInstance());
        mLoginRouter = new LoginRouter(this);
        mViewModel.setUpViewModel(loginInteractor);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = FragmentLoginBinding.inflate(inflater, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBinding.setViewModel(mViewModel);

        mBinding.loginButton.setOnClickListener(button -> mViewModel.tryToLoginUser());

        connectViewModel();
    }

    private void connectViewModel() {
        mViewModel.getLoginStatus().observe(getViewLifecycleOwner(), (loginStatus) -> {
                    switch (loginStatus) {
                        case LOGGING_IN:
                            break;
                        case LOGGED_IN:
                            mLoginRouter.goToProfilePage();
                            break;
                        case ERROR_LOGIN:
                            Toast.makeText(getContext(),"Krivi email ili lozinka",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
}

