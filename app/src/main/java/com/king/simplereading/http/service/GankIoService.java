package com.king.simplereading.http.service;

import com.king.simplereading.http.model.GankIoDataBean;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * <请描述这个类是干什么的>
 * Created by wwb on 2017/6/27 14:39.
 */

public interface GankIoService
{
    String API_GANKIO = "http://gank.io/api/";

    /**
     * 每日数据： http://gank.io/api/day/年/月/日
     * eg:http://gank.io/api/day/2015/08/06
     */



    /**
     * 分类数据: http://gank.io/api/data/数据类型/请求个数/第几页
     * 数据类型： 福利 | Android | iOS | 休息视频 | 拓展资源 | 前端 | all
     * 请求个数： 数字，大于0
     * 第几页：数字，大于0
     * eg: http://gank.io/api/data/Android/10/1
     */
    @GET("data/{type}/{pre_page}/{page}")
    Observable<GankIoDataBean> getGankIoData(@Path("type")String id,@Path("pre_page")int pre_page,@Path("page")int page);

}
