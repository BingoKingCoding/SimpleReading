package com.king.simplereading.di.modules;

import com.king.simplereading.BuildConfig;
import com.king.simplereading.di.scopes.UserScope;
import com.king.simplereading.http.Repository;
import com.king.simplereading.http.RepositoryImpl;

import java.util.concurrent.TimeUnit;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * <请描述这个类是干什么的>
 * Created by wwb on 2017/6/27 13:01.
 */
@Module
public class NetModule
{
    private String gankUrl = "http://gank.io/api/";
    private String zhihuUrl = "http://news-at.zhihu.com/api/4/";

    @Provides
    @UserScope
    Repository provideRepository(@Named("gank") Retrofit gank, @Named("zhihu") Retrofit lastfm) {
        return new RepositoryImpl(gank, lastfm);
    }

    @UserScope
    @Provides
    Retrofit.Builder provideRetrofitBuilder() {
        return new Retrofit.Builder();
    }

    @UserScope
    @Provides
    OkHttpClient.Builder provideOkHttpBuilder() {
        return new OkHttpClient.Builder();
    }

    @UserScope
    @Provides
    OkHttpClient provideClient(OkHttpClient.Builder builder) {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);
        //设置超时
        builder.connectTimeout(10, TimeUnit.SECONDS);
        builder.readTimeout(20, TimeUnit.SECONDS);
        builder.writeTimeout(20, TimeUnit.SECONDS);
        builder.addInterceptor(loggingInterceptor);
        //错误重连
        builder.retryOnConnectionFailure(true);
        return builder.build();
    }


    @Provides
    @Named("gank")
    @UserScope
    public Retrofit provideGankRetrofit(OkHttpClient client)
    {
        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(gankUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit;
    }

    @Provides
    @Named("zhihu")
    @UserScope
    public Retrofit provideZhihuRetrofit(OkHttpClient client)
    {
        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(zhihuUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit;
    }



}
