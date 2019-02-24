package com.example.jinjiezhouermn_20190223.util;

import com.example.jinjiezhouermn_20190223.api.Api;
import com.example.jinjiezhouermn_20190223.api.UserService;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitRxjavaUtil {
    private static RetrofitRxjavaUtil instance;
    private final OkHttpClient okHttpClient;
    private final Retrofit retrofit;

    private RetrofitRxjavaUtil() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .readTimeout(5,TimeUnit.SECONDS)
                .writeTimeout(5,TimeUnit.SECONDS)
                .connectTimeout(5,TimeUnit.SECONDS)
                .build();
        retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(Api.BASE_URL)
                .build();

    }
    public UserService setretrofit(){
        return retrofit.create(UserService.class);
    }
    public static RetrofitRxjavaUtil getInstance(){
        if (instance==null){
            synchronized (RetrofitRxjavaUtil.class){
                if (instance==null){
                    instance = new RetrofitRxjavaUtil();
                }
            }
        }
        return instance;
    }
}
