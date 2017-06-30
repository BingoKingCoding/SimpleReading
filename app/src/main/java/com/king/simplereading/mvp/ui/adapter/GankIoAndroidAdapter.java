package com.king.simplereading.mvp.ui.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.king.simplereading.R;
import com.king.simplereading.http.model.GankIoDataBean;

import java.util.List;

/**
 * <请描述这个类是干什么的>
 * Created by wwb on 2017/6/30 14:39.
 */

public class GankIoAndroidAdapter extends BaseQuickAdapter<GankIoDataBean.ResultBean,BaseViewHolder>
{
    public GankIoAndroidAdapter(List<GankIoDataBean.ResultBean> data)
    {
        super(R.layout.item_wechat,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, GankIoDataBean.ResultBean item)
    {

    }
}
