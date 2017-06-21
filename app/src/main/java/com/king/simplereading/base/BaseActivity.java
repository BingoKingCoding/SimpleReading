package com.king.simplereading.base;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;

import com.blankj.utilcode.util.EmptyUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.king.simplereading.rx.LifeSubscription;
import com.king.simplereading.utils.ActivityManager;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * <请描述这个类是干什么的>
 * Created by king on 2017/6/19 17:37.
 */

public abstract class BaseActivity extends RxAppCompatActivity implements LifeSubscription
{
    protected final String TAG = this.getClass().getSimpleName();
    private CompositeSubscription mCompositeSubscription;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().onCreate(this);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(getLayoutId());

    }

    protected abstract int getLayoutId();


    protected void setToolBar(Toolbar toolbar, String title) {
        setToolBar(toolbar,title,true);
    }

    protected void setToolBar(Toolbar toolbar, String title , boolean enable) {
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        getSupportActionBar().setDisplayHomeAsUpEnabled(enable);//1.显示toolbar的返回按钮左上角图标
        getSupportActionBar().setDisplayShowHomeEnabled(enable);//2.显示toolbar的返回按钮12要一起用
        getSupportActionBar().setDisplayShowTitleEnabled(enable);//显示toolbar的标题
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    @Override
    public void bindSubscription(Subscription subscription)
    {
        if (this.mCompositeSubscription == null) {
            this.mCompositeSubscription = new CompositeSubscription();
        }
        this.mCompositeSubscription.add(subscription);
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        ActivityManager.getInstance().onDestroy(this);
        if (this.mCompositeSubscription != null && mCompositeSubscription.hasSubscriptions()) {
            this.mCompositeSubscription.unsubscribe();
        }
    }

    @Override
    public void finish()
    {
        ActivityManager.getInstance().onDestroy(this);
        super.finish();
    }

    protected boolean isEmpty(Object obj)
    {
        return EmptyUtils.isEmpty(obj);
    }

    protected void toastShort(String s){
        ToastUtils.showShort(s);
    }

}
