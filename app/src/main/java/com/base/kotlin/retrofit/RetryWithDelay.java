package com.base.kotlin.retrofit;

import com.base.kotlin.utils.log.LogUtil;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

/**
 * description ：网络请求重试
 * author : zjl
 * date : 8/30/21
 */
public class RetryWithDelay implements Function<Observable<? extends Throwable>, Observable<?>> {

    private final int maxRetries;
    private final int retryDelayMillis;
    private int retryCount;

    public RetryWithDelay(int maxRetries, int retryDelayMillis) {
        this.maxRetries = maxRetries;
        this.retryDelayMillis = retryDelayMillis;
    }

    @Override
    public Observable<?> apply(Observable<? extends Throwable> attempts) {
        return attempts
                .flatMap((Function<Throwable, Observable<?>>) throwable -> {
                    if (++retryCount <= maxRetries) {
                        LogUtil.e("开始第" + retryCount + "次重新发送请求");
                        return Observable.timer(retryDelayMillis,
                                TimeUnit.MILLISECONDS);
                    }
                    return Observable.error(throwable);
                });
    }
}