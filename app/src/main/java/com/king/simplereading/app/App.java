package com.king.simplereading.app;

import android.app.Application;
import android.content.Context;

import com.blankj.utilcode.util.Utils;
import com.king.simplereading.utils.ActivityManager;

/**
 * <请描述这个类是干什么的>
 * Created by adou on 2017/6/19:22:39.
 *
 * @Email:634051075@qq.com
 */

public class App extends Application
{
    private static App sInstance;


    @Override
    public void onCreate()
    {
        super.onCreate();
        sInstance = this;
        init();
    }


    public static App getContext(Context context){
        return (App) context.getApplicationContext();
    }

    public static App getApplication()
    {
        return sInstance;
    }

    private void init(){
        Utils.init(this);
    }


    public void exitApp(boolean isBackground)
    {
        ActivityManager.getInstance().finishAllActivity();
        if (!isBackground)
        {
            System.exit(0);
        }
    }


}
