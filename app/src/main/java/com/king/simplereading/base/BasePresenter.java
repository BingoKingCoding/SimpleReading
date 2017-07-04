package com.king.simplereading.base;

import com.king.simplereading.common.AppConstants;
import com.king.simplereading.http.Callback;
import com.king.simplereading.http.HttpUtils;
import com.king.simplereading.http.Stateful;
import com.king.simplereading.rx.LifeSubscription;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.List;

import rx.Observable;


/**
 * <请描述这个类是干什么的>
 * Created by adou on 2017/6/21:22:45.
 *
 * @Email:634051075@qq.com
 */

public class BasePresenter<T extends BaseView>
{
    protected Reference<T> mReferenceView;//指的是界面，也就是BaseFragment或者BaseActivity

    protected T mView;
    private Callback mCallback;


    public void attachView(LifeSubscription mLifeSubscription){

        this.mReferenceView = new WeakReference<>((T)mLifeSubscription);
        this.mView = mReferenceView.get();
    }

    public <T> void invoke(Observable<T> observable, Callback<T> callback){
        this.mCallback = callback;
        HttpUtils.invoke((LifeSubscription)mView,observable,callback);
    }

    /**
     * 给子类检查返回集合是否为空
     * 这样子做虽然耦合度高，但是接口都不是统一定的，我们没有什么更好的办法
     *
     * @param list
     */
    public void checkState(List list) {
        if (list.size() == 0) {
            if (mView instanceof Stateful)
                ((Stateful) mView).setState(AppConstants.STATE_EMPTY);
            return;
        }
    }


    /**
     * @Description  解除与view的关系
     */
    public void detachView() {
        if (mReferenceView != null)
            mReferenceView.clear();
        mReferenceView = null;
        if (mView != null)
            mView = null;
        if (mCallback != null) {
            mCallback.detachView();
        }
    }


}
