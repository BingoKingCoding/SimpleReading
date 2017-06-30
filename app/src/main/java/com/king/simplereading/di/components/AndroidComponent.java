package com.king.simplereading.di.components;

import com.king.simplereading.di.modules.fragmentmodules.AndroidModule;
import com.king.simplereading.di.modules.httpmodules.GankIoHttpModule;
import com.king.simplereading.mvp.ui.fragment.AndroidFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * <请描述这个类是干什么的>
 * Created by wwb on 2017/6/30 15:07.
 */
@Singleton
@Component(modules = { GankIoHttpModule.class,AndroidModule.class})
public interface AndroidComponent {
    void injectAndroid(AndroidFragment androidFragment);
}
