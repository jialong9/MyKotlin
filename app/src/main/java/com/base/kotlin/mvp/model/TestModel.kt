package com.base.kotlin.mvp.model

import com.base.kotlin.ApiStore
import com.base.kotlin.base.BaseModel
import com.base.kotlin.bean.TestBean
import com.base.kotlin.retrofit.AppClient
import io.reactivex.Observable

/**
 * description ：
 * author : zjl
 * date : 8/20/21
 */
class TestModel : BaseModel {
    fun getData(): Observable<TestBean> {
//        val map: Map<String, String> = HashMap()
//        val body = RequestBody.create(MediaType.parse(ApiStore.Config.contentType), Gson().toJson(map))
        return AppClient.retrofit().create(ApiStore::class.java).getBanners()
    }
}