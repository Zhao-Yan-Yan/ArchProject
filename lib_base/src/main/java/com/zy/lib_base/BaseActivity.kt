package com.zy.lib_base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.gyf.immersionbar.ImmersionBar
import com.jaeger.library.StatusBarUtil
import java.lang.reflect.ParameterizedType

abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity() {
    lateinit var viewBinding: VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = getRealViewBinding()
        setContentView(viewBinding.root)
        initStatusBar()
        init()
    }

    private fun initStatusBar() {
        StatusBarUtil.setTransparent(this)
//        StatusBarUtil.setTransparentForImageView(this,null)
        StatusBarUtil.setLightMode(this)
    }

    abstract fun init()

    private fun getRealViewBinding(): VB {
        val type = javaClass.genericSuperclass as ParameterizedType
        val aClass = type.actualTypeArguments[0] as Class<*>
        val method = aClass.getDeclaredMethod("inflate", LayoutInflater::class.java)
        return method.invoke(null, layoutInflater) as VB
    }
}