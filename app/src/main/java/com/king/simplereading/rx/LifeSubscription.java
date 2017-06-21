package com.king.simplereading.rx;

import rx.Subscription;

/**
 * </用于添加rx的监听的在onDestroy中记得关闭不然会内存泄漏>
 * Created by wwb on 2017/6/21 15:32.
 */

public interface LifeSubscription
{
    void bindSubscription(Subscription subscription);
}
