package com.zy.application.net

class AppException(error: Error, e: Throwable?) : Exception() {
    var errorMsg: String = error.getValue()
    var errCode: Int = error.getKey()
    var errorLog: String? = e?.message
}