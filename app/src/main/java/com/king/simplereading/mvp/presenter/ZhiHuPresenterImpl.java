package com.king.simplereading.mvp.presenter;

import com.king.simplereading.base.BasePresenter;
import com.king.simplereading.http.Repository;
import com.king.simplereading.mvp.contract.ZhiHuContract;

import javax.inject.Inject;

/**
 * <请描述这个类是干什么的>
 * Created by wwb on 2017/7/11 11:32.
 */

public class ZhiHuPresenterImpl extends BasePresenter<ZhiHuContract.view> implements ZhiHuContract.Presenter
{
    private Repository mRepository;

    @Inject
    public ZhiHuPresenterImpl(Repository repository){
        this.mRepository = repository;
    }

    @Override
    public void fetchDailyData()
    {

    }

    @Override
    public void fetchThemeList()
    {

    }

    @Override
    public void fetchSectionList()
    {

    }

    @Override
    public void fetchHotList()
    {

    }
}
