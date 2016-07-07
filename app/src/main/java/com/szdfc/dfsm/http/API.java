package com.szdfc.dfsm.http;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
    private static JuHeAPI juHeAPI;
    private static OkHttpClient okHttpClient;
    public static final Gson gson =  new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm").create();
    private static Converter.Factory gsonConverterFactory = GsonConverterFactory.create(gson);
    private static CallAdapter.Factory rxJavaCallAdapterFactory = RxJavaCallAdapterFactory.create();


    public static MainAPI getMainAPI(){
        if(mainAPI == null){
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.connectTimeout(25000, TimeUnit.MILLISECONDS);
            okHttpClient = builder.build();
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://www.yqt360.com/")
                    .client(okHttpClient)
                    .addConverterFactory(gsonConverterFactory)
                    .addCallAdapterFactory(rxJavaCallAdapterFactory)
                    .build();
            mainAPI = retrofit.create(MainAPI.class);
        }
        return mainAPI;

    }

    public static JuHeAPI juHeAPI(){
        if(juHeAPI == null){
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.connectTimeout(25000, TimeUnit.MILLISECONDS);
            okHttpClient = builder.build();
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://v.juhe.cn/")
                    .client(okHttpClient)
                    .addConverterFactory(gsonConverterFactory)
                    .addCallAdapterFactory(rxJavaCallAdapterFactory)
                    .build();
            juHeAPI = retrofit.create(JuHeAPI.class);
        }
        return juHeAPI;

    }


}
