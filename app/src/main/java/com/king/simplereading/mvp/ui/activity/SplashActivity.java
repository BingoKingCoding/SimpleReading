package com.king.simplereading.mvp.ui.activity;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.king.simplereading.R;
import com.king.simplereading.base.BaseActivity;

import butterknife.BindView;

public class SplashActivity extends BaseActivity
{

    @BindView(R.id.iv_pic)
    ImageView mIvPic;

    @Override
    protected int getLayoutId()
    {
        return R.layout.activity_splash;
    }

    @Override
    protected void init(Bundle savedInstanceState)
    {
        mIvPic.setImageResource(R.mipmap.icon_curry2);
        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                toMainActivity();
            }
        },200);
    }
    private void toMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.screen_zoom_in, R.anim.screen_zoom_out);
        finish();
    }

}
