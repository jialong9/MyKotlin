package com.base.kotlin.base

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex

/**
 * description ：
 * author : zjl
 * date : 8/30/21
 */
open class BaseApplication : Application() {

    companion object {
        private var mContext: BaseApplication? = null
        fun getInstance(): BaseApplication? {
            return mContext
        }
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun onCreate() {
        super.onCreate()
        mContext = this
    }
}