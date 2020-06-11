package com.zy.application.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.zy.application.R
import com.zy.application.databinding.FragmentHomeBinding
import com.zy.lib_base.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private lateinit var homeViewModel: HomeViewModel

    override fun init() {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            viewBinding.textHome.text = it
        })
        Log.e("TAG", "onCreateView: HomeFragment")
    }

}