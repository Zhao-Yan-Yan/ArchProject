package com.zy.application.net

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.zy.lib_base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

fun BaseViewModel.requestWithDialog(
    block: suspend () -> BaseResponse,
    success: (BaseResponse) -> Unit,
    loadingMessage: String = "..."
): Job {
    return viewModelScope.launch {
        runCatching {
            pageStateChange.showLoadingDialog.postValue(loadingMessage)
            withContext(Dispatchers.IO) { block() }
        }.onSuccess {
            pageStateChange.dismissLoadingDialog.postValue(null)
            success.invoke(it)
        }.onFailure {
            pageStateChange.dismissLoadingDialog.postValue(null)
            val exception = ExceptionHandle.handleException(it)
            Toast.makeText(getApplication(), exception.errorMsg, Toast.LENGTH_SHORT).show()
        }
    }
}

fun BaseViewModel.requestWithPageStateChange(
    block: suspend () -> BaseResponse,
    success: (BaseResponse) -> Unit,
    loadingMessage: String = "..."
): Job {
    return viewModelScope.launch {
        runCatching {
            pageStateChange.showLoading.postValue(loadingMessage)
            withContext(Dispatchers.IO) { block() }
        }.onSuccess {
            pageStateChange.showNormal.postValue(null)
            success.invoke(it)
        }.onFailure {
            pageStateChange.showError.postValue(null)
            val exception = ExceptionHandle.handleException(it)
            Toast.makeText(getApplication(), exception.errorMsg, Toast.LENGTH_SHORT).show()
        }
    }
}


private fun <T> MutableLiveData<T>.paresResult(it: BaseResponse) {

}
