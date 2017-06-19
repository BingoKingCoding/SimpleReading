package com.king.simplereading.utils;

import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v7.graphics.Palette;

/**
 * <请描述这个类是干什么的>
 * Created by wwb on 2017/6/19 17:38.
 */

public class ColorUtil
{

    public static @Nullable
        Palette.Swatch getMostPopulousSwatch(Palette palette) {
            Palette.Swatch mostPopulous = null;
            if (palette != null) {
                for (Palette.Swatch swatch : palette.getSwatches()) {
                    if (mostPopulous == null || swatch.getPopulation() > mostPopulous.getPopulation()) {
                        mostPopulous = swatch;
                    }
                }
            }
            return mostPopulous;
        }


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
