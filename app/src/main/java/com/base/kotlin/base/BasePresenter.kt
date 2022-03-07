package com.base.kotlin.base

import com.base.kotlin.retrofit.RetryWithDelay
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

/**
 * description ：
 * author : zjl
 * date : 8/19/21
 */
open class BasePresenter<V> {
    var mvpView: V? = null
    private var mCompositeDisposable: CompositeDisposable? = null

    fun attachView(mvpView: V) {
        this.mvpView = mvpView
    }

    fun detachView() {
        mvpView = null
    }

    fun unDisposable() {
        mCompositeDisposable!!.dispose()
    }

    fun addDisposable(observable: Observable<*>, disposableObserver: DisposableObserver<*>) {
        if (mCompositeDisposable == null || mCompositeDisposable!!.isDisposed) {
            mCompositeDisposable = CompositeDisposable()
        }
        disposableObserver as DisposableObserver<Any>
        observable.subscribeOn(Schedulers.io())
            .retryWhen(RetryWithDelay(3, 1500))
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(disposableObserver)
        mCompositeDisposable!!.add(disposableObserver)
    }
}

