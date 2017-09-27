package com.king.simplereading.mvp.ui.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.king.simplereading.R;
import com.king.simplereading.base.BaseActivity;
import com.king.simplereading.utils.ColorUtil;

public class ScrollingActivity extends BaseActivity
{

//    String url = "http://cms-bucket.nosdn.127.net/a8628c8c3d5f465b8267593ae754b4b820170413080653.jpeg";
    String url = "http://bigtu.eastday.com/img/201306/06/95/4607166763872331683.jpg";
    private ImageView mImageView;
    private Toolbar mToolbar;
    private CollapsingToolbarLayout clptoolbar;
    @Override
    protected int getLayoutId()
    {
        return R.layout.activity_scrolling;
    }

    @Override
    protected void init(Bundle savedInstanceState)
    {
        initView();
    }

    private void initView()
    {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mImageView = (ImageView) findViewById(R.id.bar_image);
        clptoolbar = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        setToolBar(mToolbar,"Simple Reading Test Test Test Test Test Test");
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Glide.with(this).load(url).asBitmap().priority(Priority.IMMEDIATE).into(new SimpleTarget<Bitmap>()
        {
            @Override
            public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation)
            {
                mImageView.setImageBitmap(resource);
                new Palette.Builder(resource).generate(new Palette.PaletteAsyncListener()
                {
                    @Override
                    public void onGenerated(Palette palette)
                    {
                        Palette.Swatch swatch = ColorUtil.getMostPopulousSwatch(palette);
                        if (swatch != null) {
                            int color = swatch.getRgb();
                            clptoolbar.setContentScrimColor(color);
                            clptoolbar.setStatusBarScrimColor(ColorUtil.getStatusBarColor(color));
                        }
                    }
                });
            }
        });

    }
}
