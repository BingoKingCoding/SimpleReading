package com.king.simplereading.base.listgroup;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.king.simplereading.R;
import com.king.simplereading.base.BaseFragment;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * <请描述这个类是干什么的>
 * Created by wwb on 2017/7/11 11:00.
 */

public class BaseListFragment extends BaseFragment<BaseListPresenter> implements SwipeRefreshLayout.OnRefreshListener, BaseQuickAdapter.RequestLoadMoreListener
{

    @Inject
    protected BaseQuickAdapter mAdapter;

    @BindView(R.id.rv)
    RecyclerView mRv;
    @BindView(R.id.srl)
    SwipeRefreshLayout mSrl;

    private int page=1;
    private final static int PRE_PAGE = 10;
    private boolean isRefresh = true;

    @Override
    public void onRefresh()
    {

    }

    @Override
    public void onLoadMoreRequested()
    {

    }

    @Override
    protected void loadData()
    {

    }

    @Override
    protected int getLayoutId()
    {
        return R.layout.list_layout;
    }

    @Override
    protected void initView()
    {

    }

    @Override
    protected void initInject()
    {

    }
}
