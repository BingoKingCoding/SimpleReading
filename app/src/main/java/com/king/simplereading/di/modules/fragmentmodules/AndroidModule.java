package com.king.simplereading.di.modules.fragmentmodules;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.king.simplereading.mvp.ui.adapter.GankIoAndroidAdapter;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;

/**
 * <提供adapter等实例给fragment>
 * Created by wwb on 2017/6/30 14:37.
 */
@Module
public class AndroidModule
{
    @Provides
    public BaseQuickAdapter provideAdapter(){
        return new GankIoAndroidAdapter(new ArrayList());
    }
}
