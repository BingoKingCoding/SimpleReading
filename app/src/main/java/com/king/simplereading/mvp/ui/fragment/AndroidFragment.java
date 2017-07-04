package com.king.simplereading.mvp.ui.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.king.simplereading.R;
import com.king.simplereading.app.App;
import com.king.simplereading.base.BaseFragment;
import com.king.simplereading.di.components.DaggerAndroidComponent;
import com.king.simplereading.di.modules.fragmentmodules.AndroidModule;
import com.king.simplereading.http.model.GankIoDataBean;
import com.king.simplereading.mvp.contract.AndroidFragmentContract;
import com.king.simplereading.mvp.presenter.AndroidPresenter;
import com.king.simplereading.view.EasyLoadMoreView;

import java.util.List;

import butterknife.BindView;

/**
 * <请务必继承basefrahment并传入XXXPresenter（注:XXXPresenter必须继承BasePresenter）>
 * Created by adou on 2017/6/26:20:43.
 *
 * @Email:634051075@qq.com
 */

public class AndroidFragment extends BaseFragment<AndroidPresenter> implements AndroidFragmentContract.View, SwipeRefreshLayout.OnRefreshListener, BaseQuickAdapter.RequestLoadMoreListener
{
    @BindView(R.id.rv_android)
    RecyclerView mRvAndroid;
    @BindView(R.id.srl_android)
    SwipeRefreshLayout mSrlAndroid;

    private int page=1;
    private final static int PRE_PAGE = 10;
    private boolean isRefresh = true;

    @Override
    protected void loadData()
    {
        mPresenter.fetchGankIoData(page, PRE_PAGE);
    }

    @Override
    protected int getLayoutId()
    {
        return R.layout.fragment_android;
    }

    @Override
    protected void initView()
    {
        mSrlAndroid.setColorSchemeColors(getResources().getColor(R.color.colorTheme));
        mRvAndroid.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRvAndroid.setAdapter(mAdapter);
        mSrlAndroid.setOnRefreshListener(this);
        mAdapter.setLoadMoreView(new EasyLoadMoreView());
        mAdapter.setOnLoadMoreListener(this, mRvAndroid);

    }

    @Override
    protected void initInject()
    {
        DaggerAndroidComponent.builder()
                .appComponent(App.getApplication().getAppComponent())
                .androidModule(new AndroidModule())
                .build().inject(this);
    }

    @Override
    public void refreshView(List<GankIoDataBean.ResultBean> mData)
    {
        if (isRefresh)//刷新
        {
            mSrlAndroid.setRefreshing(false);
            mAdapter.setEnableLoadMore(true);
            isRefresh = false;
            mAdapter.setNewData(mData);
        } else
        {
            mSrlAndroid.setEnabled(true);
            mAdapter.addData(mData);
            mAdapter.loadMoreComplete();
        }
    }

    /**
     * @param
     * @Description 下拉刷新
     */
    @Override
    public void onRefresh()
    {
        page = 1;
        isRefresh = true;
        mAdapter.setEnableLoadMore(false);
        mPresenter.fetchGankIoData(page, PRE_PAGE);
    }

    /**
     * @param
     * @Description 上拉加载
     */
    @Override
    public void onLoadMoreRequested()
    {
        if (page >= 8)
        {
            mAdapter.loadMoreEnd();
            mSrlAndroid.setEnabled(true);
        } else
        {
            page++;
            loadData();
            mSrlAndroid.setEnabled(false);
        }
    }
}
