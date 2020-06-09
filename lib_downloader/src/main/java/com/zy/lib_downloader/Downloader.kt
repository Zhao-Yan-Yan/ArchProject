package com.zy.lib_downloader

import android.content.Context
import android.util.Log
import androidx.room.Room
import com.zy.lib_downloader.db.DownloadDatabase
import com.zy.lib_downloader.net.OkHttpUtil
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.File
import java.io.RandomAccessFile

object Downloader {

    fun download(context: Context, url: String) {

        val coroutineScope = CoroutineScope(Dispatchers.Main)
        coroutineScope.launch {
            val response = OkHttpUtil.doGet(url)
            response.body?.let {
                val file = File(context.getExternalFilesDir("下载"), getFileName(url))
                val contentLength = it.contentLength()
                val inputStream = it.byteStream()
                val buffer = ByteArray(1024 * 4)
                var len = inputStream.read(buffer)
                val randomAccessFile = RandomAccessFile(file, "rwd")
                var mCurrentDownloadSize = 0
                while (len != -1) {
                    len = inputStream.read(buffer)
                    randomAccessFile.write(buffer, 0, len)
                    mCurrentDownloadSize += len
                    Log.e("TAG", "download: ${mCurrentDownloadSize / contentLength}")
                }

            }
        }

    }

    fun initRoom(context: Context) {
        val db = Room.databaseBuilder(
            context, DownloadDatabase::class.java, "download"
        ).build()
    }

    fun getFileType(url: String): String {
        val name = url.substring(url.lastIndexOf("/") + 1, url.length)
        if (name.indexOf(".") >= 0) {
            return name.substring(name.indexOf(".") + 1, name.length)
        }
        return ""
    }

    fun getFileName(url: String): String {
        return url.substring(url.lastIndexOf("/") + 1, url.length)
    }
}