package com.king.simplereading.mvp.contract;

import com.king.simplereading.base.BaseView;

/**
 * <请描述这个类是干什么的>
 * Created by wwb on 2017/7/11 11:27.
 */

public interface ZhiHuContract
{
    interface view extends BaseView{

    }

    interface Presenter{
        void fetchDailyData();
        void fetchThemeList();
        void fetchSectionList();
        void fetchHotList();
    }

}
