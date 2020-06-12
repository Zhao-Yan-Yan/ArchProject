package com.zy.application.ui.home

import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.MergeAdapter
import com.zy.application.databinding.FragmentHomeBinding
import com.zy.application.ui.courselist.HomeBanner
import com.zy.application.ui.courselist.NotificationAdapter
import com.zy.lib_base.BaseFragment

class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding>() {
    lateinit var dialog: AlertDialog
    override fun init() {
        viewBinding.rlvMain.layoutManager = LinearLayoutManager(context)
        viewBinding.rlvMain.adapter = MergeAdapter(
            HomeBanner(), NotificationAdapter(), HomeBanner()
        )
        viewModel.getHomeData()
        viewModel.homeListData.observe(viewLifecycleOwner, Observer {
            Log.e("TAG", "init: ${Thread.currentThread()}")
            Toast.makeText(context, it.title, Toast.LENGTH_SHORT).show()
        })
        viewModel.loadingChange.showDialog.observe(viewLifecycleOwner, object : Observer<String?> {
            override fun onChanged(t: String?) {
                dialog = AlertDialog.Builder(requireContext()).setTitle("提示").setMessage(t).create()
                dialog.show()
            }
        })
        viewModel.loadingChange.dismissDialog.observe(viewLifecycleOwner, object : Observer<Void?> {
            override fun onChanged(t: Void?) {
                dialog.dismiss()
            }
        })
    }

}