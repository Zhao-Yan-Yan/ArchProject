package com.zy.lib_base

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import java.lang.reflect.ParameterizedType

abstract class BaseRecyclerViewAdapter : RecyclerView.Adapter<BaseHolder<ViewBinding>>() {
}

abstract class BaseHolder<VB : ViewBinding>(context: Context,itemView: View) : RecyclerView.ViewHolder(itemView) {
    lateinit var viewBinding: VB

    init {
        viewBinding = getRealViewBinding(LayoutInflater.from(context))
    }

    private fun getRealViewBinding(layoutInflater: LayoutInflater): VB {
        val type = javaClass.genericSuperclass as ParameterizedType
        val aClass = type.actualTypeArguments[0] as Class<*>
        val method = aClass.getDeclaredMethod("inflate", LayoutInflater::class.java)
        return method.invoke(null, layoutInflater) as VB
    }
}