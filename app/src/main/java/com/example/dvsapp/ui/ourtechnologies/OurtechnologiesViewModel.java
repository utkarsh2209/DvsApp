package com.example.dvsapp.ui.ourtechnologies;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class OurtechnologiesViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public OurtechnologiesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("");
    }

    public LiveData<String> getText() {
        return mText;
    }
}