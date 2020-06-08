package com.zy.application.widget

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.zy.application.R
import com.zy.application.databinding.WidgetUserCenterItemBinding

class UserCenterItemView : ConstraintLayout {
    var viewBinding: WidgetUserCenterItemBinding

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {

        viewBinding = WidgetUserCenterItemBinding.inflate(LayoutInflater.from(context), this, true)

        initView(attrs)
    }

    private fun initView(attrs: AttributeSet?) {
        val obtainAttrs = context.obtainStyledAttributes(attrs, R.styleable.UserCenterItemView)
        val title = obtainAttrs.getString(R.styleable.UserCenterItemView_uv_title).toString()
        val extContent = obtainAttrs.getString(R.styleable.UserCenterItemView_uv_extContent)
        val extContentColor = obtainAttrs.getColor(R.styleable.UserCenterItemView_uv_extContentColor, Color.GRAY)
        val iconResId = obtainAttrs.getResourceId(R.styleable.UserCenterItemView_uv_icon, R.mipmap.ic_user_center_order)
        val isShowMessagePoint = obtainAttrs.getBoolean(R.styleable.UserCenterItemView_uv_showMessagePoint, false)
        val isShowSplitLine = obtainAttrs.getBoolean(R.styleable.UserCenterItemView_uv_showSplitLine, true)
        obtainAttrs.recycle()

        viewBinding.let {
            it.tvItemTitle.text = title
            it.tvItemExtContent.setTextColor(extContentColor)
            it.tvItemExtContent.text = extContent
            it.imgItemIcon.setImageResource(iconResId)
            it.viewMessagePoint.visibility = if (isShowMessagePoint) {
                View.VISIBLE
            } else {
                View.GONE
            }
            it.viewBottomSplitLine.visibility = if (isShowSplitLine) {
                View.VISIBLE
            } else {
                View.GONE
            }
        }
    }

}