package com.king.simplereading.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Checkable;

/**
 * <请描述这个类是干什么的>
 * Created by wwb on 2017/7/6 16:18.
 */

public class SwitchButton extends View implements Checkable
{


    public SwitchButton(Context context)
    {
        super(context);
        init(context,null);
    }

    public SwitchButton(Context context, @Nullable AttributeSet attrs)
    {
        super(context, attrs);
        init(context,attrs);
    }

    public SwitchButton(Context context, @Nullable AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
        init(context,attrs);
    }



    private void init(Context context,AttributeSet attrs){




    }

    @Override
    public void setChecked(boolean checked)
    {

    }

    @Override
    public boolean isChecked()
    {
        return false;
    }

    @Override
    public void toggle()
    {

    }
}
