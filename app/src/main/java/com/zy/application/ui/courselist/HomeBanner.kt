package com.zy.application.ui.courselist

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.youth.banner.adapter.BannerAdapter
import com.youth.banner.listener.OnBannerListener
import com.zy.application.data.model.BannerDataEntity
import com.zy.application.databinding.HomeListItemBannerBinding
import com.zy.application.databinding.ItemBannerBinding
import com.zy.lib_base.BaseRecyclerViewAdapter
import com.zy.lib_imageloader.ImageLoader

class HomeBanner : BaseRecyclerViewAdapter<HomeBanner.Holder>() {
    private var imageUrls = listOf(
        BannerDataEntity("https://img.zcool.cn/community/011ad05e27a173a801216518a5c505.jpg"),
        BannerDataEntity("https://img.zcool.cn/community/0148fc5e27a173a8012165184aad81.jpg"),
        BannerDataEntity("https://img.zcool.cn/community/013c7d5e27a174a80121651816e521.jpg"),
        BannerDataEntity("https://img.zcool.cn/community/01b8ac5e27a173a80120a895be4d85.jpg"),
        BannerDataEntity("https://img.zcool.cn/community/01a85d5e27a174a80120a895111b2c.jpg")
    )

    inner class Holder(val viewBinding: HomeListItemBannerBinding) : RecyclerView.ViewHolder(viewBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder =
        Holder(HomeListItemBannerBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun getItemCount(): Int = 1

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.viewBinding.homeBanner.apply {
            setBannerRound(20f)
            adapter = HomeBannerAdapter(imageUrls)
            adapter.setOnBannerListener(object : OnBannerListener<Any?> {
                override fun OnBannerClick(data: Any?, position: Int) {
                    Toast.makeText(context, imageUrls[position].imageUrl, Toast.LENGTH_SHORT).show()
                }
            })
        }
    }


    inner class HomeBannerAdapter(bannerDataList: List<BannerDataEntity>) :
        BannerAdapter<BannerDataEntity, HomeBannerAdapter.Holder>(bannerDataList) {
        inner class Holder(val viewBinding: ItemBannerBinding) : RecyclerView.ViewHolder(viewBinding.root)

        override fun onCreateHolder(parent: ViewGroup, viewType: Int): Holder =
            Holder(ItemBannerBinding.inflate(LayoutInflater.from(parent.context), parent, false))

        override fun onBindView(holder: Holder, data: BannerDataEntity, position: Int, size: Int) {
            ImageLoader.load(holder.viewBinding.itemBannerImage, data.imageUrl)
        }
    }
}

