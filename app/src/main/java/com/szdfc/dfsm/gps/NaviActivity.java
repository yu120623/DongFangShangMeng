package com.szdfc.dfsm.gps;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.services.help.Inputtips;
import com.amap.api.services.help.Tip;
import com.baseandroid.activity.BaseActivity;
import com.szdfc.dfsm.R;

import java.util.List;

import butterknife.Bind;

/**
 * Created by HGo on 2016/8/10.
 */
public class NaviActivity extends BaseActivity implements AMapLocationListener {

    public static final String TAG = "NaviActiviy";

    private AMapLocationClient locationClient = null;
    private AMapLocationClientOption locationOption = null;

    @Bind(R.id.set_end)
    TextView setEnd;

    double sLat = 0.0;
    double sLng = 0.0;

    double eLat = 0.0;
    double eLng = 0.0;

    @Override
    protected void initViews() {
        showBackBtn();
        getLoc();

        setEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(context, SetAddrActivity.class));
            }
        });
    }

    private void getLoc() {
        locationClient = new AMapLocationClient(this.getApplicationContext());
        locationOption = new AMapLocationClientOption();

        locationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        // 设置定位监听
        locationClient.setLocationListener(this);

        locationClient.setLocationOption(locationOption);
        // 启动定位
        locationClient.startLocation();
    }

    @Override
    public void onLocationChanged(AMapLocation aMapLocation) {
        if (null != aMapLocation) {
            Log.w(TAG, "ErrorCode: " + aMapLocation.getErrorCode() + ", ErrorInfo: " + aMapLocation.getErrorInfo());
            locationClient.stopLocation();
            sLat = aMapLocation.getLatitude();
            sLng = aMapLocation.getLongitude();
        }
    }


    @Override
    public int getContent() {
        return R.layout.act_navi;
    }

    @Override
    public String getActionBarTitle() {
        return "请选择路线";
    }
}
