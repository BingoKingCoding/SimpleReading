package com.king.simplereading.utils;

import android.app.Activity;

import java.util.Iterator;
import java.util.Stack;

/**
 * <ActivityManager>
 * Created by wwb on 2017/6/21 15:36.
 */

public class ActivityManager
{
    private static Stack<Activity> sStackActivity;
    private static ActivityManager sInstance;

    private ActivityManager()
    {
        sStackActivity = new Stack<>();
    }

    public static ActivityManager getInstance()
    {
        if (sInstance == null)
        {
            synchronized (ActivityManager.class)
            {
                if (sInstance == null)
                {
                    sInstance = new ActivityManager();
                }
            }
        }
        return sInstance;
    }



    public void onCreate(Activity activity)
    {
        addActivity(activity);
    }

    private void addActivity(Activity activity)
    {
        if (!sStackActivity.contains(activity))
        {
            sStackActivity.add(activity);
        }
    }

    public void onDestroy(Activity activity)
    {
        removeActivity(activity);
    }

    private void removeActivity(Activity activity)
    {
        if (activity != null)
        {
            sStackActivity.remove(activity);
        }
    }

    public Activity getLastActivity()
    {
        Activity activity = null;
        try
        {
            activity = sStackActivity.lastElement();
        } catch (Exception e)
        {
        }
        return activity;
    }

    /**
     * @param
     * @Description 结束指定类名的Activity
     */
    public void finishActivity(Class<?> cls)
    {
        Iterator<Activity> it = sStackActivity.iterator();
        while (it.hasNext())
        {
            Activity act = it.next();
            if (act.getClass() == cls)
            {
                it.remove();
                act.finish();
            }
        }
    }


    public void finishAllActivity()
    {
        Iterator<Activity> it = sStackActivity.iterator();
        while (it.hasNext())
        {
            Activity act = it.next();
            it.remove();
            act.finish();
        }
    }




}
