package com.king.simplereading.http;

import com.blankj.utilcode.util.NetworkUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.king.simplereading.base.BaseView;
import com.king.simplereading.view.LoadingPage;

import rx.Subscriber;

/**
 * <继承订阅者回传数据给view>
 * Created by adou on 2017/6/21:23:00.
 *
 * @Email:634051075@qq.com
 */

public class Callback<T> extends Subscriber<T>
{
    private Stateful target;


    public void setTarget(Stateful target)
    {
        this.target = target;
    }

    public void detachView()
    {
        if (target != null)
        {
            target = null;
        }
    }

    @Override
    public void onCompleted()
    {

    }

    @Override
    public void onError(Throwable e)
    {
        e.printStackTrace();
        onfail();
    }

    @Override
    public void onNext(T data)
    {
        target.setState(LoadingPage.STATE_SUCCESS);
        onResponse();
        onResponse(data);
    }

    public void onResponse(T data)
    {
        /**
         * 如果喜欢统一处理成功回掉也是可以的。
         * 不过获取到的数据都是不规则的，理论上来说需要判断该数据是否为null或者list.size()是否为0
         * 只有不成立的情况下，才能调用成功方法refreshView/()。如果统一处理就放在每个refreshView中处理。
         */
        ((BaseView) target).refreshView(data);
    }

    public void onResponse()
    {
    }


    public void onfail()
    {
        if (!NetworkUtils.isAvailableByPing())
        {
            ToastUtils.showShort("你连接的网络有问题，请检查路由器");
            if (target != null)
            {
                target.setState(LoadingPage.STATE_ERROR);
            }
            return;
        }
        ToastUtils.showShort("程序员哥哥偷懒去了，快去举报他");
        if (target != null)
        {
            target.setState(LoadingPage.STATE_EMPTY);
        }
    }
}
