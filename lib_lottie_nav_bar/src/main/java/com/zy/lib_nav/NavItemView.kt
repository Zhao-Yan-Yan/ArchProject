package com.zy.lib_nav

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.constraintlayout.widget.ConstraintLayout
import com.zy.lib_nav.databinding.NavItemBinding

class NavItemView : RelativeLayout {
    var tab: NavView.Tab = NavView.Tab.HOME

    private var viewBinding: NavItemBinding

    private var normalLottieIcon: String
    private var selectLottieIcon: String

    private var normalTitle: String
    private var selectTitle: String

    private var normalTitleColor: Int
    private var selectTitleColor: Int

    private var normaLottieIconTintColor: Int
    private var selectLottieIconTintColor: Int

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        viewBinding = NavItemBinding.inflate(LayoutInflater.from(context), this, true)
        val obtainStyle = context.obtainStyledAttributes(attrs, R.styleable.NavItemView)
        normalTitle = obtainStyle.getString(R.styleable.NavItemView_normalTitle) ?: "home"
        selectTitle = obtainStyle.getString(R.styleable.NavItemView_selectTitle) ?: "home"
        normalLottieIcon = obtainStyle.getString(R.styleable.NavItemView_normalLottieIcon) ?: "lottie/tab_home.json"
        selectLottieIcon = obtainStyle.getString(R.styleable.NavItemView_selectLottieIcon) ?: "lottie/tab_home.json"
        normalTitleColor = obtainStyle.getColor(R.styleable.NavItemView_normalTitleColor, Color.GRAY)
        normaLottieIconTintColor = obtainStyle.getColor(R.styleable.NavItemView_normaLottieIconTintColor, Color.TRANSPARENT)
        selectTitleColor = obtainStyle.getColor(R.styleable.NavItemView_selectTitleColor, Color.BLACK)
        selectLottieIconTintColor = obtainStyle.getColor(R.styleable.NavItemView_selectLottieIconTintColor, Color.TRANSPARENT)
        obtainStyle.recycle()
        resetNavItem()
    }

    fun checkNavItem() {
        viewBinding.let {
            it.navTitle.text = selectTitle
            it.navTitle.setTextColor(selectTitleColor)
            it.navIcon.setAnimation(selectLottieIcon)
            it.navIcon.setColorFilter(selectLottieIconTintColor)
            it.navIcon.playAnimation()
        }
    }

    fun resetNavItem() {
        viewBinding.let {
            it.navTitle.text = normalTitle
            it.navTitle.setTextColor(normalTitleColor)
            it.navIcon.setAnimation(normalLottieIcon)
            it.navIcon.setMaxFrame(0)
            it.navIcon.setColorFilter(normaLottieIconTintColor)
        }
    }
}