package com.king.simplereading.http;

import com.king.simplereading.http.model.DailyListBean;

import retrofit2.http.GET;
import rx.Observable;

/**
 * <请描述这个类是干什么的>
 * Created by wwb on 2017/7/7 16:51.
 */

public interface ZhiHuService
{

    /**
     * 最新日报
     */
    @GET("news/latest")
    Observable<DailyListBean> fetchDailyList();
}
