package com.king.simplereading.utils;

import com.blankj.utilcode.util.SPUtils;
import com.king.simplereading.app.App;

/**
 * <请描述这个类是干什么的>
 * Created by wwb on 2017/6/27 10:32.
 */

public class SPConfig
{
    public static SPConfig sInstance;
    private String mStrFilename;
    private SPUtils spUtils;

    private SPConfig(){
        mStrFilename = App.getApplication().getPackageName();
        spUtils =SPUtils.getInstance(mStrFilename);
    }

    public static SPConfig getInstance(){
        if (sInstance == null)
        {
            sInstance = new SPConfig();
        }
        return sInstance;
    }

    public SPUtils getSpUtils()
    {
        return spUtils;
    }
}
