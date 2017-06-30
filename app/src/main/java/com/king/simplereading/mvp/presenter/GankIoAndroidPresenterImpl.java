package com.king.simplereading.mvp.presenter;

import com.king.simplereading.base.BasePresenter;
import com.king.simplereading.http.Callback;
import com.king.simplereading.http.model.GankIoDataBean;
import com.king.simplereading.http.service.GankIoService;
import com.king.simplereading.mvp.contract.AndroidFragmentContract;

import java.util.List;

import javax.inject.Inject;

/**
 * <请描述这个类是干什么的>
 * Created by wwb on 2017/6/27 16:03.
 */

public class GankIoAndroidPresenterImpl extends BasePresenter<AndroidFragmentContract.View> implements AndroidFragmentContract.Presenter
{
    private GankIoService mGankIoService;

    @Inject
    public GankIoAndroidPresenterImpl(GankIoService mGankIoService) {
        this.mGankIoService = mGankIoService;
    }

    @Override
    public void fetchGankIoData(int page, int pre_page)
    {
        invoke(mGankIoService.getGankIoData("Android",pre_page,page),new Callback<GankIoDataBean>(){
            @Override
            public void onResponse(GankIoDataBean data)
            {
                List<GankIoDataBean.ResultBean> results = data.getResults();
                checkState(results);
                mView.refreshView(results);
            }
        });
    }
}
