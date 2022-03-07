package com.base.kotlin.bean

import com.base.kotlin.base.BaseClassResultBean

/**
 * description ：
 * author : zjl
 * date : 8/31/21
 */
class TestBean : BaseClassResultBean<List<TestBean.TestData>>() {
    class TestData {
        private var image: String? = ""
        public var title: String? = ""
        private var url: String? = ""

        fun getImage(): String? {
            return image
        }

        fun setImage(image: String) {
            this.image = image;
        }
    }
}