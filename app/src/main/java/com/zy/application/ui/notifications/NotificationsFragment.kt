package com.zy.application.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.zy.application.R
import com.zy.application.databinding.FragmentNotificationsBinding
import com.zy.lib_downloader.Downloader

class NotificationsFragment : Fragment() {

    private lateinit var notificationsViewModel: NotificationsViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        notificationsViewModel = ViewModelProviders.of(this).get(NotificationsViewModel::class.java)
        val viewModelProvider = ViewModelProvider(this)
        val viewBinding = FragmentNotificationsBinding.inflate(inflater)
        viewBinding.uci.setOnClickListener {
            context?.let { it -> Downloader.download(it, "https://www.kotlincn.net/docs/kotlin-docs.pdf") }
        }
        // val textView: TextView = root.findViewById(R.id.text_notifications)
        /*   notificationsViewModel.text.observe(viewLifecycleOwner, Observer {
               textView.text = it
           })*/
        return viewBinding.root
    }
}

/*
*
* CREATE TABLE `routers` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `operation` varchar(16) NOT NULL COMMENT '操作跳转类型',
  `params` varchar(1024) NOT NULL COMMENT '跳转参数 数组序列化',
  `auto_change` SMALLINT UNSIGNED DEFAULT 0 COMMENT '是否该表其余信息往子表查询自动变化 1:是',
  `title` varchar(10) NOT NULL COMMENT '名称',
  `sub_title` varchar(16) NOT NULL COMMENT '副标题',
  `cover_url` varchar(512) NOT NULL COMMENT '图片地址',
  `tags` varchar(128) NOT NULL COMMENT '标签 序列化数组',
  `price` DECIMAL(19,2) NOT NULL COMMENT '现价',
  `origin_price` DECIMAL(19,2) NOT NULL COMMENT '原价',
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT '路由表';
* */