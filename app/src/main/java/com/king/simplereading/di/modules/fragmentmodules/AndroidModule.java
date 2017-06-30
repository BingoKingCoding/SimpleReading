package com.king.simplereading.di.modules.fragmentmodules;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.king.simplereading.mvp.ui.adapter.GankIoAndroidAdapter;

import java.util.ArrayList;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * <请描述这个类是干什么的>
 * Created by wwb on 2017/6/30 14:37.
 */
@Module
public class AndroidModule
{
    @Singleton
    @Provides
    public BaseQuickAdapter provideAdapter(){
        return new GankIoAndroidAdapter(new ArrayList());
    }
}
