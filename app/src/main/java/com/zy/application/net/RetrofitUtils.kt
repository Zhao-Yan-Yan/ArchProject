package com.zy.application.net

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitUtils {
    private var okHttpClient: OkHttpClient = OkHttpClient.Builder().build()

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://www.baidu.com")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val mainApiService: ApiService by lazy {
        getService(ApiService::class.java)
    }

    fun <T> getService(clazz: Class<T>): T {
        return retrofit.create(clazz)
    }
}