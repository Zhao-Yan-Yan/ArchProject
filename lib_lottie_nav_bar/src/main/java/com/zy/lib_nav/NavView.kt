package com.zy.lib_nav

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.LinearLayout
import com.zy.lib_nav.databinding.NavViewBinding

class NavView : FrameLayout {
    private var viewBinding: NavViewBinding
    private var itemViews = arrayListOf<NavItemView>()
    private var defaultSelect: Tab = Tab.HOME
    private var currentSelect: Tab = defaultSelect
    private val onNavBarClickListener: OnNavBarClickListener? = null

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        viewBinding = NavViewBinding.inflate(LayoutInflater.from(context), this, true)
    }

    override fun onFinishInflate() {
        val ll = getChildAt(0) as LinearLayout
        for (index in 0 until ll.childCount) {
            val item = ll.getChildAt(index)
            if (item is NavItemView) {
                //根据index 设置tab标签
                item.tab = Tab.valueOfIndex(index)
                itemViews.add(item)
            }
        }
        for (index in 0 until itemViews.size) {
            val navItemView = itemViews[index]
            navItemView.setOnClickListener {
                selectTab(Tab.valueOfIndex(index))
            }
        }
        super.onFinishInflate()
    }

    fun selectTab(tab: Tab) {
        for (index in 0 until itemViews.size) {
            val navItemView = itemViews[index]
            if (navItemView.tab == tab) {
                if (currentSelect.index != index) {
                    itemViews[currentSelect.index].resetNavItem()
                    currentSelect = Tab.valueOfIndex(index)
                    navItemView.checkNavItem()
                    onNavBarClickListener?.onNavClick(navItemView, navItemView.tab)
                }
                return
            }
        }
    }

    interface OnNavBarClickListener {
        fun onNavClick(navItemView: NavItemView, tab: Tab)
    }

    enum class Tab(val index: Int) {
        HOME(0),
        LEARN(1),
        USER_CENTER(2);

        companion object {
            fun valueOfIndex(index: Int): Tab {
                return when (index) {
                    0 -> HOME
                    1 -> LEARN
                    2 -> USER_CENTER
                    else -> HOME
                }
            }
        }
    }

}

