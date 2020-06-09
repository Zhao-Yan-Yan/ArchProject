package com.zy.lib_downloader.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [DownloadInfo::class], version = 1
)
abstract class DownloadDatabase : RoomDatabase() {
    abstract fun downloadInfoDao(): DownloadInfoDao
}