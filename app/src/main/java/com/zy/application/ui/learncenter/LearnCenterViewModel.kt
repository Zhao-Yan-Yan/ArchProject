package com.zy.application.ui.learncenter

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zy.lib_base.BaseViewModel

class LearnCenterViewModel(application: Application) : BaseViewModel(application) {
    fun changeValue() {
        _text.postValue("这个是改变的值")
    }

    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }
    val text: LiveData<String> = _text
}