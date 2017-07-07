package com.king.simplereading.mvp.presenter;

import com.king.simplereading.base.BasePresenter;
import com.king.simplereading.http.Callback;
import com.king.simplereading.http.Repository;
import com.king.simplereading.http.model.GankIoDataBean;
import com.king.simplereading.mvp.contract.AndroidFragmentContract;

import java.util.List;

import javax.inject.Inject;

/**
 * <请务必继承BasePresenter并传入XXXContract.view（XXXfragment或者XXXactivity必须实现该view）>
 * Created by wwb on 2017/7/4 09:53.
 */

public class AndroidPresenter extends BasePresenter<AndroidFragmentContract.View> implements AndroidFragmentContract.Presenter
{
    private Repository mRepository;

    @Inject
    public AndroidPresenter(Repository mRepository){
        this.mRepository = mRepository;
    }

    @Override
    public void fetchGankIoData(int page, int pre_page)
    {
        invoke(mRepository.getGankIoData("Android",page,pre_page),new Callback<GankIoDataBean>(){
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
