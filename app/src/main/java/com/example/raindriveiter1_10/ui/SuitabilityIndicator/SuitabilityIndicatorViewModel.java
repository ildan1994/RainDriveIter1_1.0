package com.example.raindriveiter1_10.ui.SuitabilityIndicator;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SuitabilityIndicatorViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public SuitabilityIndicatorViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}