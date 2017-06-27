package com.king.simplereading.di.modules;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * <请描述这个类是干什么的>
 * Created by wwb on 2017/6/27 13:01.
 */
@Module
public class BaseHttpModule
{
    @Singleton
    @Provides
    Retrofit.Builder provideRetrofitBuilder(){
        return new Retrofit.Builder();
    }

    @Singleton
    @Provides
    OkHttpClient.Builder provideOkHttpBuilder() {
        return new OkHttpClient.Builder();
    }

    @Singleton
    @Provides
    OkHttpClient provideOkhttpclient(OkHttpClient.Builder builder){
        return builder.connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(20,TimeUnit.SECONDS)
                .writeTimeout(20,TimeUnit.SECONDS)
                .retryOnConnectionFailure(true).build();
    }


    protected Retrofit createRetrofit(Retrofit.Builder builder, OkHttpClient client, String url){
        return builder.baseUrl(url)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }



}
