package com.king.simplereading.mvp.ui.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.king.simplereading.R;
import com.king.simplereading.base.BaseFragment;
import com.king.simplereading.mvp.ui.adapter.HomeFragmentPageAdapter;
import com.king.simplereading.view.LoadingPage;

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
    TabLayout mTabGank;
    @BindView(R.id.vp_gank)
    ViewPager mVpGank;
    private ArrayList<String> mTitleList = new ArrayList<>();
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private HomeFragmentPageAdapter mAdapter;

    @Override
    protected void loadData()
    {
        setState(LoadingPage.STATE_SUCCESS);
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
        mAdapter = new HomeFragmentPageAdapter(getChildFragmentManager(), mFragments, mTitleList);
        mVpGank.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
        mTabGank.setTabMode(TabLayout.MODE_FIXED);
        mTabGank.setupWithViewPager(mVpGank);
    }

    private void initFragments()
    {
        if (mTitleList.size() != 0)
        {
            return;
        }
        mTitleList.add("知乎日报");
        mTitleList.add("头条新闻");
        mTitleList.add("排行榜");
        mTitleList.add("最新电影");
        mFragments.add(new ZhiHuHomeFragment());
        mFragments.add(new TopNewsFragment());
        mFragments.add(new DouBanMovieTopFragment());
        mFragments.add(new DouBanMovieLatestFragment());
    }

    @Override
    protected void initInject()
    {

    }
}
