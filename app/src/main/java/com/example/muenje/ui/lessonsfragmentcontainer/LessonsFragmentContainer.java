package com.example.muenje.ui.lessonsfragmentcontainer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import com.example.muenje.BaseApplication;
import com.example.muenje.adapters.LessonsContainerPagerAdapter;
import com.example.muenje.core.RxNavigationFragment;
import com.example.muenje.data.entities.User;
import com.example.muenje.data.interactor.LessonsFragmentContainerInteractor;
import com.example.muenje.databinding.FragmentLekcijaContainerBinding;
import com.example.muenje.routers.LessonsContainerRouter;

public class LessonsFragmentContainer extends RxNavigationFragment {
    LessonsContainerPagerAdapter mLessonPagerAdapter;
    FragmentLekcijaContainerBinding mBinding;
    LessonsFragmentContainerViewModel mViewModel;
    LessonsContainerRouter mRouter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLessonPagerAdapter = new LessonsContainerPagerAdapter(this);
        mViewModel = new ViewModelProvider(requireActivity()).get(LessonsFragmentContainerViewModel.class);
        LessonsFragmentContainerArgs args = LessonsFragmentContainerArgs.fromBundle(getArguments());
        Integer lessonId = args.getLesionId();
        User user = args.getUser();
        BaseApplication application = ((BaseApplication) requireActivity().getApplication());
        mRouter = new LessonsContainerRouter(this);
        LessonsFragmentContainerInteractor interactor = new LessonsFragmentContainerInteractor(application.getRxFirebaseRealtimeDatabaseRepositoryHelper());
        mViewModel.setUpViewModel(interactor,lessonId,user);
        mViewModel.initViewModel();
   }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = FragmentLekcijaContainerBinding.inflate(inflater,container,false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBinding.setViewModel(mViewModel);
        mBinding.viewPager2.setAdapter(mLessonPagerAdapter);
        setUpPageCounter();
        connectViewModel();
    }

    void setUpPageCounter(){
        mBinding.viewPager2.registerOnPageChangeCallback(mOnPageChangeCallback);
        mBinding.lessonTotalPageNumber.setText(Integer.toString(mLessonPagerAdapter.getItemCount()));
    }

    ViewPager2.OnPageChangeCallback mOnPageChangeCallback = new ViewPager2.OnPageChangeCallback() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        @Override
        public void onPageSelected(int position) {
            mBinding.lessonCurrentPage.setText(Integer.toString(position + 1));
            if(position+1 == mLessonPagerAdapter.getItemCount()){
                mBinding.backButton.setVisibility(View.VISIBLE);
            }else {
                mBinding.backButton.setVisibility(View.GONE);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {
            super.onPageScrollStateChanged(state);
        }
    };

    void connectViewModel(){
        mViewModel.getFullLesson().observe(getViewLifecycleOwner(), (fullLesson)->
                    mBinding.lessonContainerHeaderTextView.setText(fullLesson.getTitle()));

        addDisposableToCompositeDisposable(mViewModel.getNavigationObservable().subscribe(
                (to -> mRouter.goBack())
        ));
    }
}