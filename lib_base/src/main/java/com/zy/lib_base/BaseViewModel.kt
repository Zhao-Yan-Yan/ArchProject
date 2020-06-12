package com.zy.lib_base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

open class BaseViewModel(application: Application) : AndroidViewModel(application) {

    val pageStateChange: PageStateChange by lazy { PageStateChange() }

    inner class PageStateChange {

        val showLoadingDialog by lazy { MutableLiveData<String>() }

        val dismissLoadingDialog by lazy { MutableLiveData<Void>() }

        val showEmpty by lazy { MutableLiveData<String>() }

        val showError by lazy { MutableLiveData<String>() }

        val showLoading by lazy { MutableLiveData<String>() }

        val showNormal by lazy { MutableLiveData<Void>() }

    }
}