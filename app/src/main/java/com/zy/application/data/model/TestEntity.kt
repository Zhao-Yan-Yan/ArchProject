package com.zy.application.data.model

import com.zy.application.net.BaseResponse

data class TestEntity(
    val userId: Int,
    val id: Int,
    val title: String,
    val completed: Boolean
) : BaseResponse()