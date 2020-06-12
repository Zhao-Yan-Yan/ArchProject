package com.zy.lib_base

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.jaeger.library.StatusBarUtil
import java.lang.reflect.ParameterizedType

abstract class BaseActivity<VM : BaseViewModel, VB : ViewBinding> : AppCompatActivity() {
    var loadingDialog: Dialog? = null
    lateinit var viewBinding: VB
    lateinit var viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = getRealViewBinding()
        viewModel = createViewModel()
        setContentView(viewBinding.root)
        initStatusBar()
        init()
    }

    private fun initStatusBar() {
        StatusBarUtil.setTransparent(this)
        //StatusBarUtil.setTransparentForImageView(this,null)
        StatusBarUtil.setLightMode(this)
    }

    abstract fun init()


    private fun createViewModel(): VM {
        return ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory(application)).get(getVmClazz(this))
    }

    private fun <VM> getVmClazz(obj: Any): VM {
        val type = obj.javaClass.genericSuperclass as ParameterizedType
        return type.actualTypeArguments[0] as VM
    }

    /**
     * 获取ViewBinding泛型参数
     */
    private fun getRealViewBinding(): VB {
        val type = javaClass.genericSuperclass as ParameterizedType
        val aClass = type.actualTypeArguments[1] as Class<*>
        val method = aClass.getDeclaredMethod("inflate", LayoutInflater::class.java)
        return method.invoke(null, layoutInflater) as VB
    }
}