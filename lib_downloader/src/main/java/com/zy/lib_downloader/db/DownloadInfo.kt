package com.zy.lib_downloader.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DownloadInfo(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "download_create_time") val createTime: String,
    @ColumnInfo(name = "download_update_time") val updateTime: String,
    @ColumnInfo(name = "download_url") val downloadUrl: String,
    @ColumnInfo(name = "download_save_path") val savePath: String,
    @ColumnInfo(name = "download_file_name") val fileName: String,
    @ColumnInfo(name = "download_file_type") val fileType: String,
    @ColumnInfo(name = "download_file_size") val fileSize: Long,
    @ColumnInfo(name = "download_current_size") val currentDownloadSize: Long,
    @ColumnInfo(name = "download_current_progress") val currentProgress: Float,
    @ColumnInfo(name = "download_status") val downloadStatus: Int
)