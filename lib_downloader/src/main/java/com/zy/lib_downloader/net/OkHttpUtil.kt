package com.zy.lib_downloader.net

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.*
import java.io.IOException
import java.util.concurrent.TimeUnit

object OkHttpUtil {
    private val okHttpClient = OkHttpClient.Builder()
        .connectTimeout(15, TimeUnit.SECONDS)
        .build()

    suspend fun doGet(url: String) = withContext(Dispatchers.IO) {
        val request = Request.Builder().url(url).get().build()
        val newCall = okHttpClient.newCall(request)
        Log.e("TAG", "doGet: ${Thread.currentThread().name}" )
        newCall.execute()
    }

}