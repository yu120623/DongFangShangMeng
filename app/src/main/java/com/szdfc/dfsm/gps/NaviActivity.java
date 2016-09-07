package com.szdfc.dfsm.gps;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.route.BusRouteResult;
import com.amap.api.services.route.DrivePath;
import com.amap.api.services.route.DriveRouteResult;
import com.amap.api.services.route.RouteSearch;
import com.amap.api.services.route.WalkRouteResult;
import com.baseandroid.util.CommonUtil;
import com.szdfc.dfsm.R;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by HGo on 2016/8/10.
 */
public class NaviActivity extends AppCompatActivity implements AMapLocationListener, RouteSearch.OnRouteSearchListener {

    public static final String TAG = "NaviActiviy";

    private AMapLocationClient locationClient = null;
    private AMapLocationClientOption locationOption = null;

    RouteSearch routeSearch;
    private DriveRouteResult mDriveRouteResult;

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

        routeSearch = new RouteSearch(this);
        routeSearch.setRouteSearchListener(this);
    }

    private void calRoute() {
        setStartMarker();
        setEndMarker();
        final RouteSearch.FromAndTo fromAndTo = new RouteSearch.FromAndTo(new LatLonPoint(sLat, sLng), new LatLonPoint(eLat, eLng));
        RouteSearch.DriveRouteQuery query = new RouteSearch.DriveRouteQuery(fromAndTo, RouteSearch.DrivingDefault, null, null, "");
        routeSearch.calculateDriveRouteAsyn(query);
    }

    private void setEndMarker() {
        LatLng pos = new LatLng(eLat, eLng);
        markerOption = new MarkerOptions();
        markerOption.position(pos);
        markerOption.draggable(true);
        markerOption.icon(
                BitmapDescriptorFactory.fromBitmap(BitmapFactory
                        .decodeResource(getResources(),
                                R.mipmap.point_end)));
        meMarker = aMap.addMarker(markerOption);
    }

    private void setStartMarker() {
        LatLng pos = new LatLng(sLat, sLng);
        markerOption = new MarkerOptions();
        markerOption.position(pos);
        markerOption.draggable(true);
        markerOption.icon(
                BitmapDescriptorFactory.fromBitmap(BitmapFactory
                        .decodeResource(getResources(),
                                R.mipmap.point_start)));
        meMarker = aMap.addMarker(markerOption);
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
                calRoute();
            }
        super.onActivityResult(requestCode, resultCode, data);
    }

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

    @Override
    public void onBusRouteSearched(BusRouteResult busRouteResult, int i) {

    }

    @Override
    public void onDriveRouteSearched(DriveRouteResult result, int errorCode) {
        if (errorCode == 1000) {
            if (result != null && result.getPaths() != null) {
                if (result.getPaths().size() > 0) {
                    mDriveRouteResult = result;
                    final DrivePath drivePath = mDriveRouteResult.getPaths()
                            .get(0);
                    DriveRouteColorfulOverLay drivingRouteOverlay = new DriveRouteColorfulOverLay(
                            aMap, drivePath,
                            mDriveRouteResult.getStartPos(),
                            mDriveRouteResult.getTargetPos(), null);
                    drivingRouteOverlay.setNodeIconVisibility(false);//设置节点marker是否显示
                    drivingRouteOverlay.setIsColorfulline(false);//是否用颜色展示交通拥堵情况，默认true
                    drivingRouteOverlay.removeFromMap();
                    drivingRouteOverlay.addToMap();
                    drivingRouteOverlay.zoomToSpan();
                } else if (result != null && result.getPaths() == null) {
                    CommonUtil.showMessage(getApplicationContext(), "无返回结果");
                }

            } else {
                CommonUtil.showMessage(getApplicationContext(), "无返回结果");
            }
        } else {
            CommonUtil.showMessage(getApplicationContext(), errorCode);
        }

    }

    @Override
    public void onWalkRouteSearched(WalkRouteResult walkRouteResult, int i) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_navi, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navi_btn: {
                boolean gaodeFlag = CommonUtil.isAppInstalled(getApplicationContext(), "com.autonavi.minimap");
                boolean baiduFlag = CommonUtil.isAppInstalled(getApplicationContext(), "com.baidu.BaiduMap");
                List<String> str = new ArrayList<>();
                if (gaodeFlag) {
                    str.add("高德导航");
                }
                if (baiduFlag) {
                    str.add("百度导航");
                }
                if (str.size() > 0) {
                    new android.support.v7.app.AlertDialog.Builder(this)
                            .setItems(str.toArray(new String[str.size()]), new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    if (which == 0) {
                                        Intent intent = new Intent("android.intent.action.VIEW",
                                                android.net.Uri.parse("androidamap://navi?sourceApplication=东纺商盟&poiname=fangheng&lat=" + new LatLng(sLat, sLng) + "&lon=" + new LatLng(eLat, eLng) + "&dev=1&style=2"));
                                        intent.setPackage("com.autonavi.minimap");
                                        startActivity(intent);
                                    } else if (which == 1) {
                                        try {
                                            Intent intent = Intent.getIntent("intent://map/direction?destination=latlng:" + new LatLng(sLat, sLng) + "," + new LatLng(eLat, eLng) + "|name:" + "终点" + "&mode=driving&src东纺商盟#Intent;scheme=bdapp;package=com.baidu.BaiduMap;end");
                                            startActivity(intent);
                                        } catch (URISyntaxException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }
                            }).show();
                } else {
                    CommonUtil.showMessage(getApplicationContext(), "未安装地图");
                }
            }
            break;
        }
        return super.onOptionsItemSelected(item);
    }
}
