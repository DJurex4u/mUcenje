package com.example.muenje.ui.quizFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.muenje.databinding.FragmentIzazovBinding;
import com.example.muenje.ui.QuizSharedViewModel;
import com.example.muenje.ui.quizzesContainerFragment.QuizzesContainerViewModel;

import java.util.ArrayList;
import java.util.List;


public class QuizFragment extends Fragment {

    private int mPosition;

    FragmentIzazovBinding mBinding;
    QuizzesContainerViewModel mQuizzesContainerViewModel;
    QuizViewModel mViewModel;
    QuizSharedViewModel mShareViewModel;


    public static QuizFragment newInstance(Bundle args){
        QuizFragment fragment = new QuizFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPosition = this.getArguments().getInt("page");
        mQuizzesContainerViewModel = new ViewModelProvider(requireActivity()).get(QuizzesContainerViewModel.class);
        mViewModel = new ViewModelProvider(this).get(QuizViewModel.class);
        mShareViewModel = new ViewModelProvider(getParentFragment()).get(QuizSharedViewModel.class);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = FragmentIzazovBinding.inflate(inflater,container,false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBinding.setViewModel(mViewModel);
        setUpNextClick();
        connectViewModel();
    }

    void connectViewModel(){
        mQuizzesContainerViewModel.getFullQuiz().observe( this ,(fullQuiz -> {
            mViewModel.question.setValue(fullQuiz.questionSet.get(mPosition).question);
            List<String> mPossibleAnswers = fullQuiz.questionSet.get(mPosition).possibleAnswers;
            mViewModel.possibleAnswer1.setValue(mPossibleAnswers.get(0));
            mViewModel.possibleAnswer2.setValue(mPossibleAnswers.get(1));
            mViewModel.possibleAnswer3.setValue(mPossibleAnswers.get(2));})
        );
        mViewModel.question.observe(getViewLifecycleOwner(),(question) -> mBinding.questionTextView.setText(question));
        mViewModel.possibleAnswer1.observe(getViewLifecycleOwner(),(possibleAnswer1) -> mBinding.challengeAnswer1.setText(possibleAnswer1));
        mViewModel.possibleAnswer2.observe(getViewLifecycleOwner(),(possibleAnswer2) -> mBinding.challengeAnswer2.setText(possibleAnswer2));
        mViewModel.possibleAnswer3.observe(getViewLifecycleOwner(),(possibleAnswer3) -> mBinding.challengeAnswer3.setText(possibleAnswer3));
    }

    void setUpNextClick(){
        mBinding.challengeConfirmAnswerMaterialButton.setOnClickListener((view) -> {
            Integer checkedButtonId = mBinding.challengesContainerPossibleAnswersRadioGroup.getCheckedRadioButtonId();
            if(checkedButtonId < 0){
                Toast.makeText(getActivity(),"Nije odabran niti jedan odgovor!",Toast.LENGTH_LONG).show();
            }else {
                RadioButton radioButton = mBinding.getRoot().findViewById(checkedButtonId);
                mShareViewModel.putInAnswer(radioButton.getText().toString(),mPosition);
            }
        });
    }
}