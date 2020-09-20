package com.example.muenje.ui.quizzesContainerFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import com.example.muenje.BaseApplication;
import com.example.muenje.adapters.QuizContainerPagerAdapter;
import com.example.muenje.core.RxNavigationFragment;
import com.example.muenje.data.interactor.QuizzesContainerInteractor;
import com.example.muenje.databinding.FragmentIzazoviContainerBinding;
import com.example.muenje.routers.QuizzesContainerRouter;
import com.example.muenje.ui.QuizSharedViewModel;
import com.example.muenje.utilities.AnswerChecker;


public class QuizzesContainerFragment extends RxNavigationFragment {
    FragmentIzazoviContainerBinding mBinding;
    QuizContainerPagerAdapter mAdapter;
    QuizzesContainerViewModel mViewModel;
    QuizSharedViewModel mSharedViewModel;
    QuizzesContainerRouter mRouter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BaseApplication application = (BaseApplication) requireActivity().getApplication();
        mAdapter = new QuizContainerPagerAdapter(this);
        mRouter = new QuizzesContainerRouter(this);
        QuizzesContainerFragmentArgs args = QuizzesContainerFragmentArgs.fromBundle(getArguments());
        mViewModel = new ViewModelProvider(requireActivity()).get(QuizzesContainerViewModel.class);
        mViewModel.setUpViewModel(new QuizzesContainerInteractor(application.getRxFirebaseRealtimeDatabaseRepositoryHelper()),args.getQuizId(),args.getUser());
        mSharedViewModel = new ViewModelProvider(this).get(QuizSharedViewModel.class);
        mViewModel.initViewModel();
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
        mBinding.setViewModel(mViewModel);
        mBinding.viewPager2.setUserInputEnabled(false);
        setUpPageCounter();
        connectViewModel();
    }

    void connectViewModel(){
        mViewModel.mFullQuiz.observe(getViewLifecycleOwner(),(fullQuiz -> mBinding.challengesContainerHeaderTextView.setText(fullQuiz.title)));
        mViewModel.getCorrectAnswers().observe(getViewLifecycleOwner(),(correctAnswers) -> mSharedViewModel.setUpViewModel(new AnswerChecker(correctAnswers)));
        mSharedViewModel.getUserAnswerCorrect().subscribe(
                (isCorrect) -> {
                    if (!isCorrect){
                        Toast.makeText(requireActivity(),"Netočno odgovoreno pitanje!",Toast.LENGTH_LONG).show();
                    }else {
                        if (mBinding.viewPager2.getCurrentItem() + 1 < mAdapter.getItemCount()) {
                            mBinding.viewPager2.setCurrentItem(mBinding.viewPager2.getCurrentItem() + 1);
                        }else {
                            if(mSharedViewModel.getIsInASingeShot()){
                                Toast.makeText(requireActivity(),"Isprve riješen kviz",Toast.LENGTH_LONG).show();
                            }
                            mViewModel.quizSolved(mSharedViewModel.getIsInASingeShot());
                        }
                    }
                }
        );
        addDisposableToCompositeDisposable(mViewModel.getNavigationObservable().subscribe(
                (navigateTo) -> {
                    switch (navigateTo){
                        case GO_BACK:
                            mRouter.goBack();
                            break;
                    }
                }
        ));
    }

    void setUpPageCounter(){
        mBinding.viewPager2.registerOnPageChangeCallback(mOnPageChangeCallback);
        mBinding.pageCounterLayout.lessonTotalPageNumber.setText(Integer.toString(mAdapter.getItemCount()));
    }

    ViewPager2.OnPageChangeCallback mOnPageChangeCallback = new ViewPager2.OnPageChangeCallback() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) { }

        @Override
        public void onPageSelected(int position) {
            mBinding.pageCounterLayout.lessonCurrentPage.setText(Integer.toString(position + 1));
        }

        @Override
        public void onPageScrollStateChanged(int state) {
            super.onPageScrollStateChanged(state);
        }
    };
}