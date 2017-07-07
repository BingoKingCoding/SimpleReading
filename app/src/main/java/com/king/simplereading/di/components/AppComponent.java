package com.king.simplereading.di.components;

import android.content.Context;

import com.king.simplereading.app.App;
import com.king.simplereading.di.modules.AppModule;
import com.king.simplereading.di.modules.NetModule;
import com.king.simplereading.di.scopes.UserScope;
import com.king.simplereading.http.Repository;

import dagger.Component;

/**
 * <请描述这个类是干什么的>
 * Created by adou on 2017/6/19 22 51.
 *
 * @Email:634051075@qq.com
 */
@UserScope
@Component(modules = {AppModule.class, NetModule.class})
public interface AppComponent
{
    Context getContext();// 提供App的Context
    App getApp();
    Repository repository();
}
