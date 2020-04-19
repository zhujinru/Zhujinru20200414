package com.bw.zhujinru20200414.util;

import com.bw.zhujinru20200414.Api;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * date:2020/4/14
 * author:朱金茹(Lenovo)
 * function:工具类
 */
public class NetUtil {
    private static final String BASE_URL="http://mobile.bwstudent.com/";
    private final Api api;

    public static NetUtil getInstance() {
        return SingleHolder.NET_UTIL;
    }
    private static final class SingleHolder{
        private static final NetUtil NET_UTIL=new NetUtil();
    }

    public Api getApi() {
        return api;
    }

    public NetUtil() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5, TimeUnit.SECONDS)
                .writeTimeout(5, TimeUnit.SECONDS)
                .addInterceptor(httpLoggingInterceptor)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        api = retrofit.create(Api.class);

    }
}
