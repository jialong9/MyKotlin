package com.base.kotlin

import com.base.kotlin.base.BaseClassResultBean
import com.base.kotlin.base.BaseResultBean
import com.base.kotlin.bean.TestBean
import io.reactivex.Observable
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.GET

/**
 * description ：
 * author : zjl
 * date : 8/20/21
 */
interface ApiStore {
    interface Config {
        companion object {
            @JvmStatic
            val contentType: String = "application/json"
        }
    }

    interface Url {
        companion object {
            @JvmStatic
            val baseUlr: String = "https://gank.io/"
        }
    }

    @GET("api/v2/banners")
    fun getBanners(): Observable<TestBean>
}