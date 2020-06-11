package com.zy.application.ui.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.zy.application.ui.home.HomeFragment
import com.zy.application.ui.learncenter.LearnCenterFragment
import com.zy.application.ui.usercenter.UserCenterFragment

class MainPageViewAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            1-> LearnCenterFragment()
            2-> UserCenterFragment()
            else -> HomeFragment()
        }
    }
}