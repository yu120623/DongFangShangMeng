package com.szdfc.dfsm.http;

import com.szdfc.entitylib.CateringEntity;
import com.szdfc.entitylib.CityEntity;
import com.szdfc.entitylib.PlanEntity;
import com.szdfc.entitylib.TrainEntity;
import com.szdfc.entitylib.TrainStationEntity;
import com.szdfc.entitylib.WeatherEntity;


import retrofit2.http.Query;
import rx.Observable;
import retrofit2.http.GET;

/**
 * Created by FreeMason on 2016/7/6.
 */
public interface JuHeAPI {
    //fb21c6d48c90af27f9f6b989f22d8109  format=2&cityname=%E8%8B%8F%E5%B7%9E&key=您申请的KEY
    @GET("weather/index")
    Observable<WeatherEntity> getWeather(@Query("format") String format, @Query("cityname") String cityname, @Query("key") String key);

    //航班城市
    @GET("plan/city")
    Observable<CityEntity> getPlanCity(@Query("key") String key);

    //航线查询
    @GET("plan/bc")
    Observable<PlanEntity> getPlanBC(@Query("start") String start, @Query("end") String end, @Query("date") String date, @Query("key") String key);

    @GET("catering/query")
    Observable<CateringEntity> getCatering(@Query("lng") double lng, @Query("lat") double lat, @Query("key") String key);

    //1ad4bdb773ff2255372641fe31eed702
    @GET("train/station.list.php")
    Observable<TrainStationEntity> getTrainStat(@Query("key") String key);

    //1ad4bdb773ff2255372641fe31eed702
    @GET("train/s2swithprice")
    Observable<TrainEntity> getTrainList(@Query("key") String key, @Query("start") String start, @Query("end") String end);
}
