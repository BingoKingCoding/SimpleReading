package com.king.simplereading.base;

import com.king.simplereading.http.Callback;

import java.lang.ref.Reference;

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


}
