package com.zy.application.ui.home

import android.util.Log
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.MergeAdapter
import com.zy.application.databinding.FragmentHomeBinding
import com.zy.application.ui.courselist.HomeBanner
import com.zy.application.ui.courselist.NotificationAdapter
import com.zy.lib_base.BaseFragment

class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding>() {
    override fun init() {
        viewBinding.rlvMain.layoutManager = LinearLayoutManager(context)
        viewBinding.rlvMain.adapter = MergeAdapter(
            HomeBanner(), NotificationAdapter(), HomeBanner()
        )

        //viewModel.getHomeData()
        viewModel.requestWithPageStateChange()

        viewModel.homeListData.observe(viewLifecycleOwner, Observer {
            Log.e("TAG", "init: ${it.title}")
        })

    }

}