package com.king.simplereading.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.king.simplereading.http.Stateful;
import com.king.simplereading.rx.LifeSubscription;
import com.king.simplereading.view.LoadingPage;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * <请描述这个类是干什么的>
 * Created by wwb on 2017/6/22 15:55.
 */

public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements Stateful,LifeSubscription
{

    @Inject
    protected P mPresenter;

    @Inject
    protected BaseQuickAdapter mAdapter;


    public LoadingPage mLoadingPage;

    private boolean mIsVisible = false;     // fragment是否显示了

    private boolean isPrepared = false;

    private boolean isFirst = true; //只加载一次界面


    protected View contentView;
    private Unbinder bind;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        if (mLoadingPage == null)
        {
            mLoadingPage = new LoadingPage(getContext())
            {
                @Override
                protected int getLayoutId()
                {
                    return BaseFragment.this.getLayoutId();
                }

                @Override
                protected void initView()
                {
                    if (isFirst) {
                        BaseFragment.this.contentView = this.contentView;
                        bind = ButterKnife.bind(BaseFragment.this, contentView);
                        BaseFragment.this.initView();
                        isFirst = false;
                    }
                }

                @Override
                protected void loadData()//出现网络错误点击 尝试获取时候调用
                {
                    BaseFragment.this.loadData();
                }
            };
        }

        isPrepared = true;
        loadBaseData();

        return mLoadingPage;
    }

    /**
     * 在这里实现Fragment数据的懒加载.
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser)
    {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint())
        {
            mIsVisible = true;
            onVisible();
        }else {
            mIsVisible = false;
            onInvisible();
        }
    }


    protected void onInvisible() {
    }

    /**
     * 显示时加载数据,需要这样的使用
     * 注意声明 isPrepared，先初始化
     * 生命周期会先执行 setUserVisibleHint 再执行onActivityCreated
     * 在 onActivityCreated 之后第一次显示加载数据，只加载一次
     */
    protected void onVisible() {
        if (isFirst) {
            initInject();
            if (mPresenter!=null){
                mPresenter.attachView(this);}
        }
        loadBaseData();//根据获取的数据来调用showView()切换界面
    }

    public void loadBaseData() {
        if (!mIsVisible || !isPrepared || !isFirst) {
            return;
        }
        loadData();
    }

    /**
     * 1
     * 根据网络获取的数据返回状态，每一个子类的获取网络返回的都不一样，所以要交给子类去完成
     */
    protected abstract void loadData();

    /**
     * 2
     * 网络请求成功在去加载布局
     *
     * @return
     */
    protected abstract int getLayoutId();

    /**
     * 3
     * 子类关于View的操作(如setAdapter)都必须在这里面，会因为页面状态不为成功，而binding还没创建就引用而导致空指针。
     * loadData()和initView只执行一次，如果有一些请求需要二次的不要放到loadData()里面。
     */
    protected abstract void initView();

    /**
     * dagger2注入
     */
    protected abstract void initInject();


    @Override
    public void setState(int state)
    {
        mLoadingPage.state = state;
        mLoadingPage.showPage();
    }



    private CompositeSubscription mCompositeSubscription;
    @Override
    public void bindSubscription(Subscription subscription)
    {
        if (mCompositeSubscription == null)
        {
            mCompositeSubscription = new CompositeSubscription();
        }
        mCompositeSubscription.add(subscription);
    }


    @Override
    public void onDetach()
    {
        super.onDetach();
        if (bind != null)
        {
            bind.unbind();
        }
        if (mCompositeSubscription != null &&mCompositeSubscription.hasSubscriptions())
        {
            mCompositeSubscription.unsubscribe();
        }
        if (mPresenter != null)
        {
            mPresenter.detachView();
        }
    }
}
