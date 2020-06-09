package com.zy.application

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.zy.application.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.navView.addItem("首页","lottie/tab_home.json")
        viewBinding.navView.addItem("分类","lottie/tab_classify.json")
        viewBinding.navView.addItem("发现","lottie/tab_account.json")
        viewBinding.navView.addItem("学习","lottie/tab_course.json")
        viewBinding.navView.addItem("账号","lottie/tab_note.json")
        viewBinding.navView.addItem("账号","lottie/tab_note.json")
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