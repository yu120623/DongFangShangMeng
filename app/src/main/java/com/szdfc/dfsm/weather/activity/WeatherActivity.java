package com.szdfc.dfsm.weather.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baseandroid.activity.BaseActivity;
import com.szdfc.dfsm.R;
import com.szdfc.dfsm.http.API;
import com.szdfc.dfsm.weather.util.WeatherUtil;
import com.szdfc.entitylib.WeatherEntity;

import org.w3c.dom.Text;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by FreeMason on 2016/7/6.
 */
public class WeatherActivity extends BaseActivity {
    @Bind(R.id.future_weather_layout)
    LinearLayout futureWeatherLayout;
    @Bind(R.id.humidity)
    TextView humidity;
    @Bind(R.id.wind)
    TextView wind;
    @Bind(R.id.clothe)
    TextView clothe;

    @Bind(R.id.sk_temp)
    TextView temp;
    @Bind(R.id.today_weather)
    TextView toDayWeathr;

    WeatherEntity weatherData;

    @Override
    protected void initViews() {
        showBackBtn();
        toolbar.setBackgroundColor(Color.parseColor("#163a74"));
        API.juHeWeatherAPI().getWeather("2", "苏州", "fb21c6d48c90af27f9f6b989f22d8109")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<WeatherEntity>() {
                    @Override
                    public void onCompleted() {
                        showWeather(weatherData);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(WeatherEntity weatherEntity) {
                        weatherData = weatherEntity;
                    }
                });
    }


    private void showWeather(WeatherEntity weatherEntity) {
        showFutureWeather(weatherEntity);
        WeatherEntity.ResultBean.SkBean skBean = weatherEntity.getResult().getSk();
        temp.setText(skBean.getTemp()+ "°");
        toDayWeathr.setText(weatherEntity.getResult().getToday().getWeather());
        humidity.setText(skBean.getHumidity());
        wind.setText(skBean.getWind_direction() + skBean.getWind_strength());
        clothe.setText(weatherEntity.getResult().getToday().getDressing_index());
    }

    //显示未来七天的天气
    private void showFutureWeather(WeatherEntity weatherEntity) {
        for (WeatherEntity.ResultBean.FutureBean futureBean : weatherEntity.getResult().getFuture()) {
            View futureItem = inflater.inflate(R.layout.item_weather, null, false);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT);
            params.weight = 1;
            params.gravity = Gravity.CENTER;
            futureItem.setLayoutParams(params);
            TextView week = (TextView) futureItem.findViewById(R.id.week);//周几
            TextView highestTemp = (TextView) futureItem.findViewById(R.id.highest_temp);//最高温度
            TextView minimumTemp = (TextView) futureItem.findViewById(R.id.minimum_temp);//最低温度
            ImageView imageView = (ImageView) futureItem.findViewById(R.id.weather_icon);//天气图标
            week.setText(WeatherUtil.getWeek(futureBean.getWeek()));
            highestTemp.setText(WeatherUtil.getHighestTemp(futureBean.getTemperature()) + "°");
            minimumTemp.setText(WeatherUtil.getMinimumTemp(futureBean.getTemperature()) + "°");
            imageView.setImageResource(WeatherUtil.getWeatherIcon(futureBean.getWeather_id().getFb()));
            futureWeatherLayout.addView(futureItem);
        }
    }

    @Override
    public int getContent() {
        return R.layout.act_weather;
    }

    @Override
    public String getActionBarTitle() {
        return "";
    }

}
