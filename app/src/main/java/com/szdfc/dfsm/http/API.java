package com.szdfc.dfsm.http;

import com.baseandroid.util.DateAdapter;
import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

/**
 * Created by FreeMason on 2016/4/7.
 */
public class API {
    private static MainAPI mainAPI;
    private static JuHeAPI juHeWeatherAPI;
    private static JuHeAPI juHeAPI;
    private static OkHttpClient okHttpClient;
    public static final Gson gson =  new GsonBuilder().registerTypeAdapter(Date.class,new DateAdapter()).create();
    private static Converter.Factory gsonConverterFactory = GsonConverterFactory.create(gson);
    private static CallAdapter.Factory rxJavaCallAdapterFactory = RxJavaCallAdapterFactory.create();


    public static MainAPI getMainAPI(){
        if(mainAPI == null){
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.connectTimeout(25000, TimeUnit.MILLISECONDS);
            builder.addNetworkInterceptor(new StethoInterceptor());
            okHttpClient = builder.build();
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://123.206.201.17:8080/szdfc-api/")
                    .client(okHttpClient)
                    .addConverterFactory(gsonConverterFactory)
                    .addCallAdapterFactory(rxJavaCallAdapterFactory)
                    .build();
            mainAPI = retrofit.create(MainAPI.class);
        }
        return mainAPI;
    }

    public static JuHeAPI juHeWeatherAPI(){
        if(juHeWeatherAPI == null){
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.connectTimeout(25000, TimeUnit.MILLISECONDS);
            okHttpClient = builder.build();
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://v.juhe.cn/")
                    .client(okHttpClient)
                    .addConverterFactory(gsonConverterFactory)
                    .addCallAdapterFactory(rxJavaCallAdapterFactory)
                    .build();
            juHeWeatherAPI = retrofit.create(JuHeAPI.class);
        }
        return juHeWeatherAPI;

    }

    public static JuHeAPI juHeAPI(){
        if(juHeAPI == null){
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.connectTimeout(25000, TimeUnit.MILLISECONDS);
            okHttpClient = builder.build();
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://apis.juhe.cn/")
                    .client(okHttpClient)
                    .addConverterFactory(gsonConverterFactory)
                    .addCallAdapterFactory(rxJavaCallAdapterFactory)
                    .build();
            juHeAPI = retrofit.create(JuHeAPI.class);
        }
        return juHeAPI;

    }



}
