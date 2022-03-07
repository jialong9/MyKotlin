package com.base.kotlin.mvp.presenter

import com.base.kotlin.base.BasePresenter
import com.base.kotlin.bean.TestBean
import com.base.kotlin.mvp.model.TestModel
import com.base.kotlin.mvp.view.TestView
import com.base.kotlin.retrofit.ApiCallback

/**
 * description ：
 * author : zjl
 * date : 8/20/21
 */
class TestPresenter() : BasePresenter<TestView>() {
    var testModel: TestModel? = null

    constructor(view: TestView) : this() {
        super.attachView(view)
        testModel = TestModel()
    }

    fun getBannersData() {
        addDisposable(testModel!!.getData(), object : ApiCallback<TestBean>() {
            override fun onSuccess(bean: TestBean?) {
                if (bean != null) {
                    mvpView!!.getBannersSuccess(bean)
                }
            }

            override fun onFailure(code: Int, msg: String?) {
                mvpView!!.getBannersFailed(code, msg)
            }
        })
    }
}