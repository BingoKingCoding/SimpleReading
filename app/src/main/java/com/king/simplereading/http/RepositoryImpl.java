package com.king.simplereading.http;

import com.king.simplereading.http.model.GankIoDataBean;

import retrofit2.Retrofit;
import rx.Observable;

/**
 * <请描述这个类是干什么的>
 * Created by wwb on 2017/7/7 16:40.
 */

public class RepositoryImpl implements Repository
{
    private GankIoService mGankIoService;
    private ZhiHuService mZhiHuService;

    public RepositoryImpl(Retrofit gank, Retrofit lastfm) {
        mGankIoService = gank.create(GankIoService.class);
        mZhiHuService = lastfm.create(ZhiHuService.class);
    }


    public Observable<GankIoDataBean> getGankIoData(String id,int page,int pre_page){
        return mGankIoService.getGankIoData(id,page,pre_page);
    }



}
