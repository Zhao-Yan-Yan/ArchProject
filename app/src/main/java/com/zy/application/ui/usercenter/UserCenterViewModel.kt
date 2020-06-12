package com.zy.application.ui.usercenter

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zy.lib_base.BaseViewModel

class UserCenterViewModel(application: Application) : BaseViewModel(application) {

    private val _text = MutableLiveData<String>().apply {
        value = "This is notifications Fragment"
    }
    val text: LiveData<String> = _text
}