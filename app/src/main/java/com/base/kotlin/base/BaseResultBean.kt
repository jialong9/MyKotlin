package com.base.kotlin.base

import java.io.Serializable

/**
 * description ：
 * author : zjl
 * date : 8/20/21
 */
open class BaseResultBean : Serializable {
    private var errorCode = 0
    private var success = false
    private var msg: String = ""


    fun getErrorCode(): Int {
        return errorCode
    }

    fun setErrorCode(errorCode: Int) {
        this.errorCode = errorCode
    }

    fun getSuccess(): Boolean {
        return success
    }

    fun setSuccess(success: Boolean) {
        this.success = success
    }

    fun getMsg(): String? {
        return msg
    }

    fun setMsg(msg: String) {
        this.msg = msg
    }
}