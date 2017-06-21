package com.king.simplereading.base;

/**
 * <请描述这个类是干什么的>
 * Created by adou on 2017/6/21:22:45.
 *
 * @Email:634051075@qq.com
 */

public interface BaseView<T>
{
    void refreshView(T mData);//获取数据成功调用该方法。
}
