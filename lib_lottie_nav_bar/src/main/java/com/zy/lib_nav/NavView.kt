package com.zy.lib_nav

import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.view.Gravity
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import com.zy.lib_nav.databinding.NavViewBinding

class NavView : LinearLayout {
    lateinit var viewBinding: NavViewBinding
    var mWidth: Int = 0
    private var navItems = arrayListOf<NavItemView>()
    var currentSelectHashCode: Int = 0
    var lastSelectHashCode: Int = 0

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        viewBinding = NavViewBinding.inflate(LayoutInflater.from(context), this, true)
        for (navItemView in navItems) {
            viewBinding.root.addView(navItemView)
        }
    }

    fun addItem(title: String, iconAssetsName: String) {
        if (navItems.size < MAX_ITEMS) {
            val navItemView = NavItemView.generateNavItemView(context, title, iconAssetsName)
            navItemView.setOnClickListener {
                lastSelectHashCode = currentSelectHashCode
                for (navItem in navItems) {
                    if (navItem.hashCode() == lastSelectHashCode) {
                        navItem.select = false
                    }
                }
                currentSelectHashCode = navItemView.hashCode()
                navItemView.select = (navItemView.hashCode() == currentSelectHashCode)
            }
            if (navItems.size > 0) {
                navItemView.layoutParams = LayoutParams(mWidth / navItems.size, ViewGroup.LayoutParams.WRAP_CONTENT, 1.0f)
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                navItemView.foregroundGravity = Gravity.CENTER
            }
            navItems.add(navItemView)
            viewBinding.root.addView(navItemView)
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        mWidth = measuredWidth
    }

    override fun onFinishInflate() {
        super.onFinishInflate()

    }

    companion object {
        const val MAX_ITEMS = 5
    }
}

