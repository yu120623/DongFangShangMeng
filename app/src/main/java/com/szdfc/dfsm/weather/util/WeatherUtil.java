package com.szdfc.dfsm.weather.util;

import com.szdfc.dfsm.R;

/**
 * Created by FreeMason on 2016/7/6.
 */
public class WeatherUtil {
    public static String getWeek(String week){
        return week.replace("星期","周");
    }

    public static String getHighestTemp(String temp){
        return temp.substring(temp.indexOf("~") + 1, temp.length()-1);
    }

    public static String getMinimumTemp(String temp){
        return temp.substring(0,temp.indexOf("~")-1);
    }

    public static int getWeatherIcon(String w){
        int imgRes = 0;
        switch(w){
            case "00":
                imgRes = R.mipmap.w00;
                break;
            case "01":
                imgRes = R.mipmap.w01;
                break;
            case "02":
                imgRes = R.mipmap.w02;
                break;
            case "03":
                imgRes = R.mipmap.w03;
                break;
            case "04":
                imgRes = R.mipmap.w04;
                break;
            case "05":
                imgRes = R.mipmap.w05;
                break;
            case "06":
                imgRes = R.mipmap.w06;
                break;
            case "07":
                imgRes = R.mipmap.w07;
                break;
            case "08":
                imgRes = R.mipmap.w08;
                break;
            case "09":
                imgRes = R.mipmap.w09;
                break;
            case "10":
                imgRes = R.mipmap.w10;
                break;
            case "11":
                imgRes = R.mipmap.w11;
                break;
            case "12":
                imgRes = R.mipmap.w12;
                break;
            case "13":
                imgRes = R.mipmap.w13;
                break;
            case "14":
                imgRes = R.mipmap.w14;
                break;
            case "15":
                imgRes = R.mipmap.w15;
                break;
            case "16":
                imgRes = R.mipmap.w16;
                break;
            case "17":
                imgRes = R.mipmap.w17;
                break;
            case "18":
                imgRes = R.mipmap.w18;
                break;
            case "19":
                imgRes = R.mipmap.w19;
                break;
            case "20":
                imgRes = R.mipmap.w20;
                break;
            case "21":
                imgRes = R.mipmap.w21;
                break;
            case "22":
                imgRes = R.mipmap.w22;
                break;
            case "23":
                imgRes = R.mipmap.w23;
                break;
            case "24":
                imgRes = R.mipmap.w24;
                break;
            case "25":
                imgRes = R.mipmap.w25;
                break;
            case "26":
                imgRes = R.mipmap.w26;
                break;
            case "27":
                imgRes = R.mipmap.w27;
                break;
            case "28":
                imgRes = R.mipmap.w28;
                break;
            case "29":
                imgRes = R.mipmap.w29;
                break;
            case "30":
                imgRes = R.mipmap.w30;
                break;
            case "31":
                imgRes = R.mipmap.w31;
                break;
            case "53":
                imgRes = R.mipmap.w53;
                break;
        }
        return imgRes;
    }
}
