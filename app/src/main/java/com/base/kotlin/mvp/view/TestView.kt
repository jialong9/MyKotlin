package com.base.kotlin.mvp.view

import com.base.kotlin.bean.TestBean


/**
 * description ：
 * author : zjl
 * date : 8/20/21
 */
interface TestView {
    fun getBannersSuccess(bean: TestBean)
    fun getBannersFailed(code: Int, msg: String?)
}