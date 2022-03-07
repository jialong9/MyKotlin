package com.base.kotlin.base

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.base.kotlin.utils.ActivityManagerUtil

/**
 * description ：
 * author : zjl
 * date : 8/18/21
 */
abstract class BaseActivity : AppCompatActivity() {
    var mContext: Context? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        mContext = this
        initData(savedInstanceState)
        ActivityManagerUtil.getInstance().getActivityStackInfo()
    }

    abstract fun getLayoutId(): Int
    abstract fun initData(savedInstanceState: Bundle?)
}