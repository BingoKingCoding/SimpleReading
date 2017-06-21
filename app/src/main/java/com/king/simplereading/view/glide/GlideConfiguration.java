package com.king.simplereading.view.glide;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory;
import com.bumptech.glide.module.GlideModule;

/**
 * <Glide配置>
 * Created by wwb on 2017/6/21 14:56.
 * 中文WIKi： https://muzhi1991.gitbooks.io/android-glide-wiki/content/chapter2.html
 */

public class GlideConfiguration implements GlideModule
{
    public static final int IMAGE_DISK_CACHE_MAX_SIZE = 100 * 1024 * 1024;//图片缓存文件最大值为100Mb

    @Override
    public void applyOptions(Context context, GlideBuilder builder)
    {
        new InternalCacheDiskCacheFactory(context, "CacheImage", DiskCache.Factory.DEFAULT_DISK_CACHE_SIZE);
    }

    @Override
    public void registerComponents(Context context, Glide glide)
    {

    }
}
