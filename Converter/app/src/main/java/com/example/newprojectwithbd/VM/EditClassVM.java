package com.example.newprojectwithbd.VM;


import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class EditClassVM extends ViewModel {
    public MutableLiveData<String> list = new MutableLiveData <>();

    public void addToList (String code) {
        list.postValue(code);
    }



}
