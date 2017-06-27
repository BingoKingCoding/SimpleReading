package com.king.simplereading.mvp.contract;

import com.king.simplereading.base.BaseView;
import com.king.simplereading.http.model.GankIoDataBean;

import java.util.List;

/**
 * <请描述这个类是干什么的>
 * Created by wwb on 2017/6/27 12:44.
 */

public interface AndroidFragmentContract
{
    interface View extends BaseView<List<GankIoDataBean.ResultBean>>{

    }

    interface Presenter {
        void fetchGankIoData(int page, int pre_page);
    }

}
