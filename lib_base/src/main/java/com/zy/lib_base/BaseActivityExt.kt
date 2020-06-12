package com.zy.lib_base

import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer

fun BaseActivity<*, *>.registerStateChange() {
    this.viewModel.pageStateChange.showLoadingDialog.observe(this, Observer { showLoadingDialog(it) })

    this.viewModel.pageStateChange.dismissLoadingDialog.observe(this, Observer { dismissLoadingDialog() })

    this.viewModel.pageStateChange.showLoading.observe(this, Observer { showLoading() })

    this.viewModel.pageStateChange.showEmpty.observe(this, Observer { showEmpty() })

    this.viewModel.pageStateChange.showError.observe(this, Observer { showError() })

    this.viewModel.pageStateChange.showNormal.observe(this, Observer { showData() })
}

fun BaseActivity<*, *>.showError() {

}

fun BaseActivity<*, *>.showData() {
}

fun BaseActivity<*, *>.showEmpty() {

}

fun BaseActivity<*, *>.showLoading() {

}

fun BaseActivity<*, *>.showLoadingDialog(msg: String) {
    loadingDialog = AlertDialog.Builder(this).setTitle("提示").setMessage(msg).create()
    loadingDialog?.show()
}

fun BaseActivity<*, *>.dismissLoadingDialog() {
    loadingDialog?.dismiss()
}
