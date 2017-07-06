package com.king.simplereading.view.webview;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;

import com.blankj.utilcode.util.NetworkUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.king.simplereading.mvp.ui.activity.WebViewActivity;

/**
 * <请描述这个类是干什么的>
 * Created by wwb on 2017/7/4 17:55.
 */

public class AppJsHandler extends BaseJsHandler
{
    private static final String DEFAULT_NAME = "App";
    private String url;

    public AppJsHandler(String name, Activity activity)
    {
        super(name, activity);
    }

    public AppJsHandler(Activity activity)
    {
        this(DEFAULT_NAME, activity);
    }

    @JavascriptInterface
    public void imageClick(String imgUrl, String hasLink) {
//        Toast.makeText(context, "----点击了图片", Toast.LENGTH_SHORT).show();
        // 查看大图
//        Intent intent = new Intent(context, ViewBigImageActivity.class);
//        context.startActivity(intent);
        Log.e("----点击了图片 url: ", "" + imgUrl);
    }

    @JavascriptInterface
    public void textClick(String type, String item_pk) {
        if (!TextUtils.isEmpty(type) && !TextUtils.isEmpty(item_pk)) {
            ToastUtils.showShort("----点击了文字");
        }
    }

    /**
     * @Description 检查网络
     */
    @JavascriptInterface
    public void check_network()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("网络设置提示");
        builder.setMessage("网络连接不可用，是否进行设置?");
        builder.setNegativeButton("取消", null);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                NetworkUtils.openWirelessSettings();
            }
        });
        builder.show();
    }

    /**
     * @Description 重新加载
     */
    @JavascriptInterface
    public void refresh_reload()
    {
        ((WebViewActivity)getActivity()).loadUrl();
    }


}
