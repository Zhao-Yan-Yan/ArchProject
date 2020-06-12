package com.zy.application.net

import com.zy.application.data.model.TestEntity
import retrofit2.http.GET
import retrofit2.http.Url
import java.util.*

interface ApiService {
    @GET
    suspend fun test(@Url url: String): TestEntity
}