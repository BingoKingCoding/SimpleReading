package com.king.simplereading.http;

import com.blankj.utilcode.util.NetworkUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.king.simplereading.common.AppConstants;
import com.king.simplereading.rx.LifeSubscription;

import rx.android.schedulers.AndroidSchedulers;
import rx.Observable;
import rx.Subscription;
import rx.schedulers.Schedulers;


/**
 * <请描述这个类是干什么的>
 * Created by wwb on 2017/6/22 10:36.
 */

public class HttpUtils
{
    public static <T> void invoke(LifeSubscription lifecycle, Observable<T> observable, Callback<T> callback)
    {
        Stateful target = null;
        if (lifecycle instanceof Stateful)
        {
            target = (Stateful) lifecycle;
            callback.setTarget(target);
        }

        if (!NetworkUtils.isConnected())
        {
            ToastUtils.showShort("网络连接已断开");
            if (target != null)
            {
                target.setState(AppConstants.STATE_ERROR);
            }
            return;
        }

        Subscription subscription = observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callback);
        lifecycle.bindSubscription(subscription);

    }
}
