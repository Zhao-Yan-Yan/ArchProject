package com.zy.lib_nav

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.constraintlayout.widget.ConstraintLayout
import com.zy.lib_nav.databinding.NavItemBinding

class NavItemView : ConstraintLayout {
    lateinit var viewBinding: NavItemBinding
    var select: Boolean = true
        set(value) {
            field = value
            viewBinding.let {
                if (select) {
                    it.navTitle.text = selectTitle
                    it.navIcon.setAnimation(selectLottieIcon)
                    it.navIcon.playAnimation()
                } else {
                    it.navTitle.text = normalTitle
                    it.navIcon.setImageResource(android.R.drawable.ic_menu_add)
//                    it.navIcon.setAnimation(selectLottieIcon)
                }
            }
        }
    var normalLottieIcon: String = "lottie/tab_home.json"
    var selectLottieIcon: String = "lottie/tab_home.json"
    var normalTitle: String = "tab_home"
    var selectTitle: String = "tab_home"

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        viewBinding = NavItemBinding.inflate(LayoutInflater.from(context), this, true)
    }


    companion object {
        fun generateNavItemView(
            context: Context,
            normalTitle: String,
            normalLottieIcon: String,
            selectTitle: String = normalTitle,
            selectLottieIcon: String = normalLottieIcon
        ): NavItemView {
            val navItemView = NavItemView(context)
            navItemView.let {
                it.normalTitle = normalTitle
                it.selectTitle = selectTitle
                it.normalLottieIcon = normalLottieIcon
                it.selectLottieIcon = selectLottieIcon
            }
            return navItemView
        }
    }
}