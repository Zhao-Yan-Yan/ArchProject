package com.zy.lib_nav

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.LinearLayout
import com.zy.lib_nav.databinding.NavViewBinding

class NavView : FrameLayout {
    private var viewBinding: NavViewBinding
    private var itemViews = arrayListOf<NavItemView>()
    private var defaultSelect: Tab = Tab.HOME
    private var currentSelect: Tab = defaultSelect
    private var lastSelect: Tab? = null
    private var onNavBarClickListener: ((Tab) -> Unit)? = null
    private var isFirstSelect = false
    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        viewBinding = NavViewBinding.inflate(LayoutInflater.from(context), this, true)

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
        postDelayed({
            selectTab(Tab.HOME)
            isFirstSelect = true
        }, 500)
    }

    private fun selectTab(tab: Tab) {
        for (index in 0 until itemViews.size) {
            val navItemView = itemViews[index]
            if (navItemView.tab == tab && lastSelect != tab) {
                if (lastSelect != null) {
                    val last = lastSelect?.index ?: 0
                    itemViews[last].resetNavItem()
                }
                currentSelect = Tab.valueOfIndex(index)
                navItemView.checkNavItem()
                lastSelect = Tab.valueOfIndex(index)
                onNavBarClickListener?.invoke(navItemView.tab)
                break
            }
        }
    }

    private fun setOnNavBarClickListener(onNavBarClickListener: (tab: Tab) -> Unit) {
        this.onNavBarClickListener = onNavBarClickListener
    }

    fun bindWithViewPager(viewPager2: ViewPager2) {
        setOnNavBarClickListener { tab ->
            viewPager2.currentItem = tab.index
        }
        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                if(isFirstSelect){
                    selectTab(Tab.valueOfIndex(position))
                }
            }
        })
    }

    enum class Tab(val index: Int) {
        /**
         * 首页
         */
        HOME(0),

        /**
         * 学习
         */
        LEARN(1),

        /**
         * 用户中心
         */
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

