package com.king.simplereading.mvp.ui.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import com.king.simplereading.R;
import com.king.simplereading.base.BaseFragment;
import com.king.simplereading.common.AppConstants;
import com.king.simplereading.mvp.ui.adapter.HomeFragmentPageAdapter;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * <请描述这个类是干什么的>
 * Created by adou on 2017/6/26:20:44.
 *
 * @Email:634051075@qq.com
 */

public class HomeFragment extends BaseFragment
{
    @BindView(R.id.tab_gank)
    Toolbar mTabGank;
    @BindView(R.id.vp_gank)
    ViewPager mVpGank;

    private ArrayList<String> mTitleList = new ArrayList<>();
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private HomeFragmentPageAdapter mAdapter;
    @Override
    protected void loadData()
    {
        setState(AppConstants.STATE_SUCCESS);
    }

    @Override
    protected int getLayoutId()
    {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView()
    {
        initFragments();
    }

    private void initFragments()
    {
        if(mTitleList.size()!=0){
            return;
        }
    }

    @Override
    protected void initInject()
    {

    }
}
