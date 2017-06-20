package com.king.simplereading.di.components;

import com.king.simplereading.app.App;
import com.king.simplereading.di.modules.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * <请描述这个类是干什么的>
 * Created by adou on 2017/6/19 22 51.
 *
 * @Email:634051075@qq.com
 */
@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent
{
    App getContext();// 提供App的Context

}
