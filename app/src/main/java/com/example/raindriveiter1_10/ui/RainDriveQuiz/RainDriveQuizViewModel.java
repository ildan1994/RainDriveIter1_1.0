package com.example.raindriveiter1_10.ui.RainDriveQuiz;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RainDriveQuizViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public RainDriveQuizViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is slideshow fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}