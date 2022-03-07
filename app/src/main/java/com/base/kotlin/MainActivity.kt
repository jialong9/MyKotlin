package com.base.kotlin

import android.os.Bundle
import com.base.kotlin.base.MvpActivity
import com.base.kotlin.bean.TestBean
import com.base.kotlin.mvp.presenter.TestPresenter
import com.base.kotlin.mvp.view.TestView
import kotlinx.android.synthetic.main.activity_main.*

/**
 * description ：
 * author : zjl
 * date : 8/17/21
 */
class MainActivity : MvpActivity<TestPresenter>(), TestView {
    private var num: Int = 0

    override fun initPresenter(): TestPresenter? {
        return TestPresenter(this)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initData(savedInstanceState: Bundle?) {
        bt_test.setOnClickListener {
            bt_test.text = num++.toString()
            mPresenter!!.getBannersData()
        }
    }


    override fun getBannersSuccess(bean: TestBean) {
        tv_title.text  = bean.getData()!![0].title
    }

    override fun getBannersFailed(code: Int, msg: String?) {
    }
}