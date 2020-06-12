package com.zy.application.ui.main

import android.os.Bundle
import androidx.navigation.*
import com.zy.application.R
import com.zy.application.databinding.ActivityMainBinding
import com.zy.lib_base.BaseActivity

class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {

    override fun init() {
        val builder = NavOptions.Builder()
            .setLaunchSingleTop(true)
            .setEnterAnim(R.anim.nav_default_enter_anim)
            .setExitAnim(R.anim.nav_default_exit_anim)
            .setPopEnterAnim(R.anim.nav_default_pop_enter_anim)
            .setPopExitAnim(R.anim.nav_default_pop_exit_anim)

        viewBinding.let {
            it.mainPageView.adapter = MainPageViewAdapter(supportFragmentManager, lifecycle)
            it.navView.bindWithViewPager(it.mainPageView)
        }
    }
}