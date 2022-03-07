package com.base.kotlin.utils

import android.app.Activity
import java.util.*

/**
 * description ：
 * author : zjl
 * date : 8/18/21
 */
class ActivityManagerUtil() {
    init {
        //无参构造函数(主构造函数) 默认自带
    }

    constructor(str: String) : this() {
        //有参构造函数(次构造函数 可有多个)
        //Kotlin 中规定，当一个类既有主构造函数又有次构造函数时，
        // 所有次构造函数都必须使用this关键字直接或间接的调用主构造函数
        //（当类名够加了圆括号，无论有没有参数，就需要遵守这个规定）
    }

    companion object {
        @JvmField
        var mActivityStack: Stack<Activity>? = null

        @JvmField
        var mActivityManagerUtil: ActivityManagerUtil? = null

        @JvmStatic
        fun getInstance(): ActivityManagerUtil {
            if (mActivityManagerUtil == null) {
                mActivityManagerUtil = ActivityManagerUtil();
            }
            return mActivityManagerUtil!!
        }
    }

    fun getActivityNum(): Int {
        return mActivityStack!!.size
    }

    /**
     * 把activity添加到栈里
     */
    fun addActivity(activity: Activity?) {
        if (mActivityStack == null) {
            mActivityStack = Stack()
        }
        mActivityStack!!.add(activity)
    }

    /**
     * 在栈里移除activity并且关闭activity
     */
    fun killActivity(activity: Activity?) {
        mActivityStack!!.remove(activity)
        activity!!.finish()
    }

    /**
     * 通过类名删除指定activity
     */
    fun killActivity(cla: Class<*>) {
        for (i in mActivityStack!!.size - 1 downTo 1) {
            if (mActivityStack!![i].javaClass == cla) {
                killActivity(mActivityStack!![i])
            }
        }
    }

    /**
     * 关闭所有activity
     */
    fun killAllActivity() {
        for (i in 0 until mActivityStack!!.size) {
            mActivityStack!![i]!!.finish()
        }
        mActivityStack!!.clear()
    }

    /**
     *获取指定activity
     */
    fun getActivity(cla: Class<*>): Activity? {
        for (i in mActivityStack!!.size - 1 downTo 1) {
            if (mActivityStack!![i].javaClass == cla) {
                return mActivityStack!![i]
            }
        }
        return null
    }

    /**
     * 打印activity栈内信息
     */
    fun getActivityStackInfo() {
        for (i in 0 until (mActivityStack?.size ?: 0)) {
            val activity = mActivityStack!![i]
            println(activity.javaClass.simpleName)
        }
    }
}