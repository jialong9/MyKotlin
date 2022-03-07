package com.base.kotlin.base

/**
 * description ：
 * author : zjl
 * date : 8/20/21
 */
open class BaseClassResultBean<T> : BaseResultBean() {
    private var data: T? = null
    open fun getData(): T? {
        return data
    }

    open fun setData(data: T?) {
        this.data = data
    }
}