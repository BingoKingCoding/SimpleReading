package com.king.simplereading.view;

import com.chad.library.adapter.base.loadmore.LoadMoreView;
import com.king.simplereading.R;

/**
 * <请描述这个类是干什么的>
 * Created by wwb on 2017/6/27 16:47.
 */

public class EasyLoadMoreView extends LoadMoreView
{
    @Override
    public int getLayoutId()
    {
        return R.layout.base_load_more;
    }

    @Override
    protected int getLoadingViewId()
    {
        return R.id.load_more_loading_view;
    }

    @Override
    protected int getLoadFailViewId()
    {
        return R.id.load_more_load_fail_view;
    }

    @Override
    protected int getLoadEndViewId()
    {
        return R.id.load_more_load_end_view;
    }
}
