package com.zy.application.ui.home

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.zy.application.data.model.TestEntity
import com.zy.application.net.ExceptionHandle
import com.zy.application.net.RetrofitUtils
import com.zy.application.net.requestWithDialog
import com.zy.application.net.requestWithPageStateChange
import com.zy.lib_base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel(application: Application) : BaseViewModel(application) {
    private val _homeListData = MutableLiveData<TestEntity>()
    val homeListData: LiveData<TestEntity> = _homeListData

    fun getHomeData() {
        viewModelScope.launch {
            runCatching {
                pageStateChange.showLoadingDialog.postValue("加载中。。。")
                withContext(Dispatchers.IO) {
                    RetrofitUtils.mainApiService.test("https://jsonplaceholder.typicode.com/todos/1")
                }
            }.onSuccess {
                pageStateChange.dismissLoadingDialog.postValue(null)
                _homeListData.postValue(it)
            }.onFailure {
                it.printStackTrace()
                Log.e("TAG", "getHomeData: " + it.cause)
                val e = ExceptionHandle.handleException(it)
                Toast.makeText(getApplication(), e.errorMsg, Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun requestWithDialog() {
        requestWithDialog(
            { testData() },
            { _homeListData.postValue(it as TestEntity) }
        )
    }

    fun requestWithPageStateChange() {
        requestWithPageStateChange(
            { testData() },
            { _homeListData.postValue(it as TestEntity) }
        )
    }

    private suspend fun testData() = withContext(Dispatchers.IO) {
        RetrofitUtils.mainApiService.test("https://jsonplaceholder.typicode.com/todos/1")
    }
}