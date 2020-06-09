package com.zy.lib_downloader.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DownloadInfoDao {
    @Insert()
    fun addDownloadTask()
}