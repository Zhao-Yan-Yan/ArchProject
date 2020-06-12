package com.zy.lib_base

import android.graphics.Color
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer

fun BaseFragment<*, *>.registerStateChange() {
    this.viewModel.pageStateChange.showLoadingDialog.observe(viewLifecycleOwner, Observer { showLoadingDialog(it) })

    this.viewModel.pageStateChange.dismissLoadingDialog.observe(viewLifecycleOwner, Observer { dismissLoadingDialog() })

    this.viewModel.pageStateChange.showLoading.observe(viewLifecycleOwner, Observer { showLoading() })

    this.viewModel.pageStateChange.showEmpty.observe(viewLifecycleOwner, Observer { showEmpty() })

    this.viewModel.pageStateChange.showError.observe(viewLifecycleOwner, Observer { showError() })

    this.viewModel.pageStateChange.showNormal.observe(viewLifecycleOwner, Observer { showData() })
}

fun BaseFragment<*, *>.showError() {

}

fun BaseFragment<*, *>.showData() {
    viewBinding.root.setBackgroundColor(Color.TRANSPARENT)
}

fun BaseFragment<*, *>.showEmpty() {

}

fun BaseFragment<*, *>.showLoading() {
    viewBinding.root.setBackgroundColor(Color.GRAY)
}

fun BaseFragment<*, *>.showLoadingDialog(msg: String) {
    loadingDialog = AlertDialog.Builder(requireContext()).setTitle("提示").setMessage(msg).create()
    loadingDialog?.show()
}

fun BaseFragment<*, *>.dismissLoadingDialog() {
    loadingDialog?.dismiss()
}