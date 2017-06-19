package com.king.simplereading.utils;

import android.graphics.Color;

/**
 * <请描述这个类是干什么的>
 * Created by wwb on 2017/6/19 17:38.
 */

public class ColorUtil
{
    /**
     * @Description 获取状态栏颜色
     */
    public static int getStatusBarColor(int color)
    {
        float[] arrayOfFloat = new float[3];
        Color.colorToHSV(color, arrayOfFloat);
        arrayOfFloat[2] *= 0.9F;
        return Color.HSVToColor(arrayOfFloat);
    }
}
