package com.king.simplereading.di.modules;

import com.king.simplereading.BuildConfig;
import com.king.simplereading.http.ApiService;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

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
    private String baseUrl = "http://gank.io/api/";

    @Singleton
    @Provides
    public OkHttpClient provideOkHttpClient()
    {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);
        //设置超时
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                //错误重连
                .retryOnConnectionFailure(true)
                .addInterceptor(loggingInterceptor)
                .build();
        return okHttpClient;
    }

    @Singleton
    @Provides
    public Retrofit provideRetrofit(OkHttpClient client)
    {
        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        return retrofit;
    }

    @Singleton
    @Provides
    public ApiService provideApiService(Retrofit retrofit)
    {
        return retrofit.create(ApiService.class);
    }


}
