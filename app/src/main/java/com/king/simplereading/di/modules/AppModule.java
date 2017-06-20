package com.king.simplereading.di.modules;

import com.king.simplereading.app.App;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * <请描述这个类是干什么的>
 * Created by adou on 2017/6/19 22 52.
 *
 * @Email:634051075@qq.com
 */
@Module
public class AppModule
{
    private App mApp;

    public AppModule(App app){
        this.mApp= app;
    }


    @Provides
    @Singleton
    public App provideApplicationContext()
    {
        return mApp;
    }
}
