package com.king.simplereading.di.components;

import com.king.simplereading.di.modules.fragmentmodules.AndroidModule;
import com.king.simplereading.di.scopes.ActivityScope;
import com.king.simplereading.mvp.ui.fragment.AndroidFragment;

import dagger.Component;

/**
 * <请描述这个类是干什么的>
 * Created by wwb on 2017/7/4 09:50.
 */

@ActivityScope
@Component(modules = AndroidModule.class,dependencies = AppComponent.class)
public interface AndroidComponent
{
    void inject(AndroidFragment androidFragment);
}
