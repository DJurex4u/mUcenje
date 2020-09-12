package com.example.muenje.ui.lekcijaFragmentContainer;

import androidx.lifecycle.MutableLiveData;

import com.example.muenje.adapters.LectionsContainerPagerAdapter;

import java.util.ArrayList;

public class LekcijaFragmentContainerViewModel {

    MutableLiveData<String> mHeader = new MutableLiveData<>();
    MutableLiveData<ArrayList<String>> mLectionsList = new MutableLiveData<>();


}
