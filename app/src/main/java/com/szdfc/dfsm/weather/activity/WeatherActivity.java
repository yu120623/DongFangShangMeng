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
    @Override
    protected void initViews() {
        showBackBtn();
        toolbar.setBackgroundColor(Color.parseColor("#163a74"));
        WeatherEntity weatherEntity = API.gson.fromJson("{\n" +
                "    \"resultcode\": \"200\",\n" +
                "    \"reason\": \"查询成功!\",\n" +
                "    \"result\": {\n" +
                "        \"sk\": {\t/*当前实况天气*/\n" +
                "            \"temp\": \"21\",\t/*当前温度*/\n" +
                "            \"wind_direction\": \"西风\",\t/*当前风向*/\n" +
                "            \"wind_strength\": \"2级\",\t/*当前风力*/\t\n" +
                "            \"humidity\": \"4%\",\t/*当前湿度*/\n" +
                "            \"time\": \"14:25\"\t/*更新时间*/\n" +
                "        },\n" +
                "        \"today\": {\n" +
                "            \"city\": \"天津\",\n" +
                "            \"date_y\": \"2014年03月21日\",\n" +
                "            \"week\": \"星期五\",\n" +
                "            \"temperature\": \"8℃~20℃\",\t/*今日温度*/\n" +
                "            \"weather\": \"晴转霾\",\t/*今日天气*/\n" +
                "            \"weather_id\": {\t/*天气唯一标识*/\n" +
                "                \"fa\": \"00\",\t/*天气标识00：晴*/\n" +
                "                \"fb\": \"53\"\t/*天气标识53：霾 如果fa不等于fb，说明是组合天气*/\n" +
                "            },\n" +
                "            \"wind\": \"西南风微风\",\n" +
                "            \"dressing_index\": \"较冷\", /*穿衣指数*/\n" +
                "            \"dressing_advice\": \"建议着大衣、呢外套加毛衣、卫衣等服装。\",\t/*穿衣建议*/\n" +
                "            \"uv_index\": \"中等\",\t/*紫外线强度*/\n" +
                "            \"comfort_index\": \"\",/*舒适度指数*/\n" +
                "            \"wash_index\": \"较适宜\",\t/*洗车指数*/\n" +
                "            \"travel_index\": \"适宜\",\t/*旅游指数*/\n" +
                "            \"exercise_index\": \"较适宜\",\t/*晨练指数*/\n" +
                "            \"drying_index\": \"\"/*干燥指数*/\n" +
                "        },\n" +
                "        \"future\": [\t/*未来几天天气*/\n" +
                "            {\n" +
                "                \"temperature\": \"28℃~36℃\",\n" +
                "                \"weather\": \"晴转多云\",\n" +
                "                \"weather_id\": {\n" +
                "                    \"fa\": \"00\",\n" +
                "                    \"fb\": \"01\"\n" +
                "                },\n" +
                "                \"wind\": \"南风3-4级\",\n" +
                "                \"week\": \"星期一\",\n" +
                "                \"date\": \"20140804\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"temperature\": \"28℃~36℃\",\n" +
                "                \"weather\": \"晴转多云\",\n" +
                "                \"weather_id\": {\n" +
                "                    \"fa\": \"00\",\n" +
                "                    \"fb\": \"01\"\n" +
                "                },\n" +
                "                \"wind\": \"东南风3-4级\",\n" +
                "                \"week\": \"星期二\",\n" +
                "                \"date\": \"20140805\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"temperature\": \"27℃~35℃\",\n" +
                "                \"weather\": \"晴转多云\",\n" +
                "                \"weather_id\": {\n" +
                "                    \"fa\": \"00\",\n" +
                "                    \"fb\": \"01\"\n" +
                "                },\n" +
                "                \"wind\": \"东南风3-4级\",\n" +
                "                \"week\": \"星期三\",\n" +
                "                \"date\": \"20140806\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"temperature\": \"27℃~34℃\",\n" +
                "                \"weather\": \"多云\",\n" +
                "                \"weather_id\": {\n" +
                "                    \"fa\": \"01\",\n" +
                "                    \"fb\": \"01\"\n" +
                "                },\n" +
                "                \"wind\": \"东南风3-4级\",\n" +
                "                \"week\": \"星期四\",\n" +
                "                \"date\": \"20140807\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"temperature\": \"27℃~33℃\",\n" +
                "                \"weather\": \"多云\",\n" +
                "                \"weather_id\": {\n" +
                "                    \"fa\": \"01\",\n" +
                "                    \"fb\": \"01\"\n" +
                "                },\n" +
                "                \"wind\": \"东北风4-5级\",\n" +
                "                \"week\": \"星期五\",\n" +
                "                \"date\": \"20140808\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"temperature\": \"26℃~33℃\",\n" +
                "                \"weather\": \"多云\",\n" +
                "                \"weather_id\": {\n" +
                "                    \"fa\": \"01\",\n" +
                "                    \"fb\": \"01\"\n" +
                "                },\n" +
                "                \"wind\": \"北风4-5级\",\n" +
                "                \"week\": \"星期六\",\n" +
                "                \"date\": \"20140809\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"temperature\": \"26℃~33℃\",\n" +
                "                \"weather\": \"多云\",\n" +
                "                \"weather_id\": {\n" +
                "                    \"fa\": \"01\",\n" +
                "                    \"fb\": \"01\"\n" +
                "                },\n" +
                "                \"wind\": \"北风4-5级\",\n" +
                "                \"week\": \"星期日\",\n" +
                "                \"date\": \"20140810\"\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"error_code\": 0\n" +
                "}", WeatherEntity.class);
        showWeather(weatherEntity);
    }


    private void showWeather(WeatherEntity weatherEntity) {
        showFutureWeather(weatherEntity);
        WeatherEntity.ResultBean.SkBean skBean = weatherEntity.getResult().getSk();
        humidity.setText(skBean.getHumidity());
        wind.setText(skBean.getWind_direction()+skBean.getWind_strength());
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
