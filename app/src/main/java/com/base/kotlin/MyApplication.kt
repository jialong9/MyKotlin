package com.base.kotlin

import android.app.Activity
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.base.kotlin.base.BaseApplication
import com.base.kotlin.retrofit.AppClient
import com.base.kotlin.utils.ActivityManagerUtil
import com.base.kotlin.utils.log.LogUtil
import io.reactivex.plugins.RxJavaPlugins
import java.util.function.Consumer

/**
 * description ：
 * author : zjl
 * date : 8/30/21
 */
class MyApplication : BaseApplication() {
    override fun onCreate() {
        super.onCreate()
        //初始化LogUtil

        AppClient.setApiServerUrl(ApiStore.Url.baseUlr)
        checkRxJavaError()
        getActivityStatus()
    }

    private fun checkRxJavaError() {
        //代码解释 https://blog.csdn.net/guangdeshishe/article/details/98846824
        RxJavaPlugins.setErrorHandler {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                Consumer<Throwable> { t -> t.printStackTrace() }
            }
        }
    }

    private fun getActivityStatus() {
        registerActivityLifecycleCallbacks(object : ActivityLifecycleCallbacks {
            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
                ActivityManagerUtil.getInstance().addActivity(activity)
                LogUtil.i("当前onActivityCreated的是----------", activity.javaClass.simpleName)
            }

            override fun onActivityStarted(activity: Activity) {
                LogUtil.i("当前onActivityStarted的是----------", activity.javaClass.simpleName)
            }

            override fun onActivityResumed(activity: Activity) {
                LogUtil.i("当前onActivityResumed的是----------", activity.javaClass.simpleName)
            }

            override fun onActivityPaused(activity: Activity) {
                LogUtil.i("当前onActivityPaused的是----------", activity.javaClass.simpleName)
            }

            override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
                LogUtil.i(
                    "当前onActivitySaveInstanceState的是----------",
                    activity.javaClass.simpleName
                )
            }

            override fun onActivityStopped(activity: Activity) {
                LogUtil.i("当前onActivityStopped的是----------", activity.javaClass.simpleName)
            }

            override fun onActivityDestroyed(activity: Activity) {
                ActivityManagerUtil.getInstance().killActivity(activity)
                LogUtil.i("当前onActivityDestroyed的是----------", activity.javaClass.simpleName)

            }
        })
    }
}