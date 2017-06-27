package com.king.simplereading.di.modules.httpmodules;

import com.king.simplereading.di.modules.BaseHttpModule;
import com.king.simplereading.di.qualifier.GankUrl;
import com.king.simplereading.http.service.GankIoService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * <请描述这个类是干什么的>
 * Created by wwb on 2017/6/27 14:37.
 */
@Module
public class GankIoHttpModule extends BaseHttpModule
{
    @Singleton
    @Provides
    @GankUrl
    Retrofit provideGankIoRetrofit(Retrofit.Builder builder, OkHttpClient client)
    {
        return createRetrofit(builder,client, GankIoService.API_GANKIO);
    }

    @Provides
    @Singleton
    GankIoService provideGankIoService(@GankUrl Retrofit retrofit){
        return retrofit.create(GankIoService.class);
    }


}
