package com.king.simplereading.mvp.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * <请描述这个类是干什么的>
 * Created by adou on 2017/6/26:20:48.
 *
 * @Email:634051075@qq.com
 */

public class HomeFragmentPageAdapter extends FragmentPagerAdapter
{
    private List<Fragment> mFragmentList;
    private List<String> mTitleList;

    public HomeFragmentPageAdapter(FragmentManager fm, List<Fragment> fragmentList)
    {
        this(fm, fragmentList, null);
    }


    public HomeFragmentPageAdapter(FragmentManager fm, List<Fragment> fragmentList, List<String> titleList)
    {
        super(fm);
        this.mFragmentList = fragmentList;
        this.mTitleList = titleList;
    }

    @Override
    public Fragment getItem(int position)
    {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount()
    {
        return mFragmentList.size();
    }

    /**
     * @Description
     * 首页显示title，每日推荐等..
     * 若有问题，移到对应单独页面
     */
    @Override
    public CharSequence getPageTitle(int position)
    {
        if (mTitleList != null)
        {
            return mTitleList.get(position);
        }
        return "";
    }
}
