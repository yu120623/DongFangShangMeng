package com.szdfc.dfsm.gps;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.amap.api.col.dh;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdate;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.services.help.Inputtips;
import com.amap.api.services.help.Tip;
import com.baseandroid.activity.BaseActivity;
import com.szdfc.dfsm.R;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by HGo on 2016/8/10.
 */
public class NaviActivity extends AppCompatActivity implements AMapLocationListener {

    public static final String TAG = "NaviActiviy";

    private AMapLocationClient locationClient = null;
    private AMapLocationClientOption locationOption = null;

    @Bind(R.id.set_end)
    TextView setEnd;

    @Bind(R.id.set_start)
    TextView setStart;


    @Bind(R.id.tool_bar)
    Toolbar toolbar;

    @Bind(R.id.map)
    MapView mapView;
    private AMap aMap;
    private MarkerOptions markerOption;
    private Marker meMarker;

    double sLat = 0.0;
    double sLng = 0.0;
    double mLat = 0.0;
    double mLng = 0.0;
    double eLat = 0.0;
    double eLng = 0.0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_navi);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        toolbar.setTitle("选择路线");
        getSupportActionBar().setTitle("选择路线");
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setNavigationIcon(R.mipmap.ic_gf_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        getLoc();
        mapView.onCreate(savedInstanceState);// 此方法必须重写

        setEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(getApplicationContext(), SetAddrActivity.class), 2);
            }
        });

        setStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(getApplicationContext(), SetAddrActivity.class), 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK)
            if (requestCode == 1) {
                sLat = data.getDoubleExtra("lat", 0);
                sLng = data.getDoubleExtra("lng", 0);
                setStart.setText(data.getStringExtra("name"));

            } else if (requestCode == 2) {
                eLat = data.getDoubleExtra("lat", 0);
                eLng = data.getDoubleExtra("lng", 0);
                setEnd.setText(data.getStringExtra("name"));
            }
        super.onActivityResult(requestCode, resultCode, data);
    }

    //    @Override
//    protected void initViews() {
//        showBackBtn();
//        initMap();
//        getLoc();
//    }

    private void initMap() {
        if (aMap == null) {
            aMap = mapView.getMap();
            aMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(sLat, sLng), 19));
            setUpMap();
        }
    }

    private void setUpMap() {
        LatLng pos = new LatLng(sLat, sLng);
        markerOption = new MarkerOptions();
        markerOption.position(pos);
        //markerOption.title("我的位置").snippet("西安市：34.341568, 108.940174");
        markerOption.title("我的位置");
        markerOption.draggable(true);
        markerOption.icon(
                BitmapDescriptorFactory.fromBitmap(BitmapFactory
                        .decodeResource(getResources(),
                                R.mipmap.point_me)));
        // 将Marker设置为贴地显示，可以双指下拉看效果
        //markerOption.setFlat(true);
        meMarker = aMap.addMarker(markerOption);
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
            Log.w(TAG, "onLocationChanged: " + sLat + "," + sLng);
            initMap();
        }
    }

    /**
     * 方法必须重写
     */
    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    /**
     * 方法必须重写
     */
    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
    }

    /**
     * 方法必须重写
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

    /**
     * 方法必须重写
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

//    @Override
//    public int getContent() {
//        return R.layout.act_navi;
//    }
//
//    @Override
//    public String getActionBarTitle() {
//        return "请选择路线";
//    }
}
