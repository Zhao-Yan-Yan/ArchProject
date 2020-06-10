package com.zy.application

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.zy.application.databinding.ActivityMainBinding
import com.zy.lib_nav.NavView

class MainActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        viewBinding.navView.selectTab(NavView.Tab.HOME)
      /*  val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home,
                R.id.navigation_dashboard,
                R.id.navigation_notifications
            )
        )
        viewBinding.let {
            val navController = findNavController(R.id.nav_host_fragment)
            setupActionBarWithNavController(navController, appBarConfiguration)
            it.navView.setupWithNavController(navController)
        }*/
    }
}