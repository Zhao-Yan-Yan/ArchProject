package com.zy.lib_base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

open class BaseViewModel(application: Application) : AndroidViewModel(application) {

    val loadingChange: LoadingChange by lazy { LoadingChange() }

    inner class LoadingChange {
        val showDialog by lazy { MutableLiveData<String>() }
        val dismissDialog by lazy { MutableLiveData<Void>() }
    }
}