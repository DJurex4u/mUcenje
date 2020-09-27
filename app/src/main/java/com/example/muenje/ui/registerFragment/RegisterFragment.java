package com.example.muenje.ui.registerFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.example.muenje.BaseApplication;
import com.example.muenje.core.RxNavigationFragment;
import com.example.muenje.data.interactor.RegisterInteractor;
import com.example.muenje.databinding.FragmentRegisterBinding;
import com.example.muenje.routers.RegisterRouter;

public class RegisterFragment extends RxNavigationFragment {

    FragmentRegisterBinding mBinding;
    RegisterViewModel mViewModel;
    RegisterRouter mRegisterRouter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BaseApplication application = ((BaseApplication) requireActivity().getApplication());
        mViewModel = new ViewModelProvider(requireActivity()).get(RegisterViewModel.class);
        RegisterInteractor registerInteractor = new RegisterInteractor(application.getRxFirebaseHelperInstance());
        mRegisterRouter = new RegisterRouter(this);
        mViewModel.setUpViewModel(registerInteractor);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    mBinding = FragmentRegisterBinding.inflate(inflater,container,false);
    return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBinding.setViewModel(mViewModel);
        connectViewModel();
    }

    private void connectViewModel(){
        mViewModel.getRegisterStatus().observe(getViewLifecycleOwner(),(registerStatus -> {
            switch (registerStatus){
                case NOT_ALL_FILLED:
                    Toast.makeText(getContext(),"Sva polja moraju biti popunjena!",Toast.LENGTH_LONG).show();
                    break;
                case EMAIL_ALREADY_IN_USE:
                    Toast.makeText(getContext(),"email se već koristi!",Toast.LENGTH_LONG).show();
                    break;
                case PASSWORD_TOO_SHORT:
                    Toast.makeText(getContext(),"Lozinka mora imati barem 6 znakova!",Toast.LENGTH_LONG).show();
                    break;
                case PASSWORDS_DO_NOT_MATCH:
                    Toast.makeText(getContext(),"Lozinke se ne podudaraju!",Toast.LENGTH_LONG).show();
                    break;
                case REGISTERING:
                    break;
                case REGISTERED:
                    try{
                        mRegisterRouter.navigateToProfilePage(mViewModel.getUser());
                    }catch (NullPointerException mException){
                        throw mException;
//                        System.out.println(mException.getMessage());
                    }
                    break;
                case INVALID_EMAIL:
                    Toast.makeText(getContext(),"email nije valjan!",Toast.LENGTH_LONG).show();
                    break;
                case ERROR_REGISTRATION:
                    Toast.makeText(getContext(),"Došlo je do pogreške pri registraciji.",Toast.LENGTH_LONG).show();

                    break;
            }
        }));
        loginNavigation();

    }
    
    private void loginNavigation(){
        addDisposableToCompositeDisposable(mViewModel.getNavigationObservable().subscribe((to)->{
            switch (to){
                case GO_TO_LOGIN_PAGE:
                    mRegisterRouter.navigateToLoginPage();
                    break;
                default:
                    throw new IllegalStateException("Unexpected value RegisterFragment: " + to);
            }
        }));
    }
}