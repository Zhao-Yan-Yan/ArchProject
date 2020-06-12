package com.zy.lib_base

import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseRecyclerViewAdapter<VH : RecyclerView.ViewHolder> : RecyclerView.Adapter<VH>() {
}

abstract class BaseHolder(itemView: View) : RecyclerView.ViewHolder(itemView)