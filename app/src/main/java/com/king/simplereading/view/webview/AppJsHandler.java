package com.king.simplereading.view.webview;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;

import com.blankj.utilcode.util.ToastUtils;

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

}
