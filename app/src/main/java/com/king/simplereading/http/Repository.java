package com.king.simplereading.http;

import com.king.simplereading.http.model.GankIoDataBean;

import rx.Observable;

/**
 * <请描述这个类是干什么的>
 * Created by wwb on 2017/7/7 16:39.
 */

public interface Repository
{
    Observable<GankIoDataBean> getGankIoData(String id, int page, int pre_page);
}
