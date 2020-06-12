package com.zy.lib_imageloader

import android.annotation.SuppressLint
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions


object ImageLoader {
    fun load(imageView: ImageView, imageUrl: String, roundingRadius: Int = 25) {
        val fadeTransition = DrawableTransitionOptions.withCrossFade()
        val requestOptions = RequestOptions()
            .transform(CenterCrop(), RoundedCorners(roundingRadius))
            .error(R.drawable.shape_imageloader_error)
            .placeholder(R.drawable.shape_imageloader_place_holder)
        Glide.with(imageView.context)
            .applyDefaultRequestOptions(requestOptions)
            .load(imageUrl)
            .skipMemoryCache(false)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .transition(fadeTransition)
            .into(imageView)
    }

}