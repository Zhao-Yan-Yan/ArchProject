package com.zy.application.ui.learncenter

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.lifecycleScope
import com.google.gson.Gson
import com.zy.application.R
import com.zy.application.data.model.TestEntity
import com.zy.application.databinding.FragmentLearnCenterBinding
import com.zy.lib_base.BaseFragment
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LearnCenterFragment : BaseFragment<LearnCenterViewModel, FragmentLearnCenterBinding>() {


    override fun init() {
        viewModel.request()

        viewModel._homeListData.observe(viewLifecycleOwner, Observer {
            viewBinding.textDashboard.text = Gson().toJson(it)
        })
    }
}