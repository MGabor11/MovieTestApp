package com.example.movietestapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class ActivitySharedViewModel @Inject constructor() : ViewModel() {

    val isLoading : MutableLiveData<Boolean> = MutableLiveData()

}
