package com.zy.application.ui.learncenter

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zy.application.data.model.TestEntity
import com.zy.application.net.RetrofitUtils
import com.zy.application.net.requestWithDialog
import com.zy.application.net.requestWithPageStateChange
import com.zy.lib_base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LearnCenterViewModel(application: Application) : BaseViewModel(application) {
     val _homeListData = MutableLiveData<TestEntity>()
    fun request() {
        requestWithDialog(
            { testData() },
            { _homeListData.postValue(it as TestEntity) }
        )
    }

    private suspend fun testData() = withContext(Dispatchers.IO) {
        RetrofitUtils.mainApiService.test("https://jsonplaceholder.typicode.com/todos/1")
    }
}