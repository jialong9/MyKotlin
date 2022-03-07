package com.base.kotlin.base

import android.os.Bundle
import com.base.kotlin.mvp.view.TestView


/**
 * description ：
 * author : zjl
 * date : 8/19/21
 */
abstract class MvpActivity<P : BasePresenter<*>> : BaseActivity() {
    var mPresenter: P? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        mPresenter = initPresenter()
        super.onCreate(savedInstanceState)
    }

    abstract fun initPresenter(): P?

    override fun onDestroy() {
        super.onDestroy()
        mPresenter!!.detachView()
    }
}