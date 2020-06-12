package com.zy.application.ui.courselist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.youth.banner.Banner
import com.youth.banner.adapter.BannerAdapter
import com.zy.application.data.model.NotificationBannerDataEntity
import com.zy.application.databinding.HomeListItemNotificationBinding
import com.zy.application.databinding.ItemBannerNotificationBinding
import com.zy.lib_base.BaseRecyclerViewAdapter

class NotificationAdapter : BaseRecyclerViewAdapter<NotificationAdapter.Holder>() {
    val list = arrayListOf<NotificationBannerDataEntity>(
        NotificationBannerDataEntity("NotificationBannerDataEntity1"),
        NotificationBannerDataEntity("NotificationBannerDataEntity2"),
        NotificationBannerDataEntity("NotificationBannerDataEntity3"),
        NotificationBannerDataEntity("NotificationBannerDataEntity4")
    )

    class Holder(val viewBinding: HomeListItemNotificationBinding) : RecyclerView.ViewHolder(viewBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder =
        Holder(HomeListItemNotificationBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun getItemCount(): Int = 1

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.viewBinding.homeNotificationBanner.let {
            it.adapter = NotificationBannerAdapter(list)
            it.setOrientation(Banner.VERTICAL)
            it.start()
        }
    }

    inner class NotificationBannerAdapter(notificationDataList: List<NotificationBannerDataEntity>) :
        BannerAdapter<NotificationBannerDataEntity, NotificationBannerAdapter.Holder>(notificationDataList) {
        inner class Holder(val viewBinding: ItemBannerNotificationBinding) : RecyclerView.ViewHolder(fixWH(viewBinding.root))

        override fun onBindView(
            holder: NotificationBannerAdapter.Holder?,
            data: NotificationBannerDataEntity?,
            position: Int,
            size: Int
        ) {
            holder?.viewBinding?.itemBannerNotificationTitle?.text = data?.title
        }

        fun fixWH(view: View): View {
            val params = view.layoutParams
            //这里判断高度和宽带是否都是match_parent
            //这里判断高度和宽带是否都是match_parent
            if (params.height != ViewGroup.LayoutParams.MATCH_PARENT || params.width != ViewGroup.LayoutParams.MATCH_PARENT) {
                params.height = ViewGroup.LayoutParams.MATCH_PARENT
                params.width = ViewGroup.LayoutParams.MATCH_PARENT
                view.layoutParams = params
            }
            return view
        }

        override fun onCreateHolder(parent: ViewGroup?, viewType: Int): NotificationBannerAdapter.Holder =
            Holder(ItemBannerNotificationBinding.inflate(LayoutInflater.from(parent?.context), parent, false))
    }
}