package com.szdfc.dfsm.hotel;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.poisearch.PoiResult;
import com.amap.api.services.poisearch.PoiSearch;
import com.baseandroid.activity.BaseActivity;
import com.baseandroid.recyclerview.RecyclerViewDivider;
import com.cundong.recyclerview.HeaderAndFooterRecyclerViewAdapter;
import com.cundong.recyclerview.RecyclerViewUtils;
import com.szdfc.dfsm.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class HotelActivity extends BaseActivity implements AMapLocationListener, PoiSearch.OnPoiSearchListener {

    @Bind(R.id.hotel_list)
    RecyclerView recyclerView;

    public static final String TAG = "HotelActivity";

    private AMapLocationClient locationClient = null;
    private AMapLocationClientOption locationOption = null;
    private PoiSearch.Query query;

    double lat = 0.0;
    double lng = 0.0;
    String cityCode = "";

    HotelAdapter adapter;

    List<View> viewList = new ArrayList<>();

    View header;

    PagerAdapter viewPagerAdapter = new PagerAdapter() {


        @Override
        public int getCount() {
            return viewList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position,
                                Object object) {
            container.removeView(viewList.get(position));
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(viewList.get(position));
            return viewList.get(position);
        }
    };


    @Override
    protected void initViews() {
        showBackBtn();
        initHeader();

        getLoc();
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

    private void initHeader() {
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        header = inflater.inflate(R.layout.header_hotel, null, false);
        adapter = new HotelAdapter();
        recyclerView.addItemDecoration(new RecyclerViewDivider(context, 1));
        HeaderAndFooterRecyclerViewAdapter headerAdapter = new HeaderAndFooterRecyclerViewAdapter(adapter);
        recyclerView.setAdapter(headerAdapter);
        RecyclerViewUtils.setHeaderView(recyclerView, header);

        ViewPager viewPager = (ViewPager) header.findViewById(R.id.hotel_view_pager);
        viewPager.setAdapter(viewPagerAdapter);
        for (int i = 0; i < 4; i++) {
            LayoutInflater inflater = getLayoutInflater();
            View view1 = inflater.inflate(R.layout.item_home_view_page, null);
            viewList.add(view1);
            ImageView imageView = (ImageView) view1.findViewById(R.id.view_img);
            imageView.setBackgroundResource(R.mipmap.bg);
            viewPagerAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onLocationChanged(AMapLocation aMapLocation) {
        if (null != aMapLocation) {
            Log.w(TAG, "ErrorCode: " + aMapLocation.getErrorCode() + ", ErrorInfo: " + aMapLocation.getErrorInfo());
            locationClient.stopLocation();
            lat = aMapLocation.getLatitude();
            lng = aMapLocation.getLongitude();
            cityCode = aMapLocation.getCityCode();
            search();
        }
    }

    private void search() {
        query = new PoiSearch.Query("", "住宿服务", cityCode);
        query.setPageSize(10);// 设置每页最多返回多少条poiitem
        query.setPageNum(1);//设置查第一页
        PoiSearch poiSearch = new PoiSearch(this, query);
        poiSearch = new PoiSearch(this, query);
        poiSearch.setOnPoiSearchListener(this);
        poiSearch.setBound(new PoiSearch.SearchBound(new LatLonPoint(lat, lng), 5000, true));//
        // 设置搜索区域为以lp点为圆心，其周围5000米范围
        poiSearch.searchPOIAsyn();// 异步搜索
    }

    @Override
    public void onPoiSearched(PoiResult poiResult, int i) {
        poiResult.getPois();

    }

    @Override
    public void onPoiItemSearched(PoiItem poiItem, int i) {

    }


    class HotelAdapter extends RecyclerView.Adapter<HotelViewHolder> {

        @Override
        public HotelViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = inflater.inflate(R.layout.item_hotel, parent, false);
            return new HotelViewHolder(view);
        }

        @Override
        public void onBindViewHolder(HotelViewHolder holder, int position) {
        }


        @Override
        public int getItemCount() {
            return 10;
        }
    }

    class HotelViewHolder extends RecyclerView.ViewHolder {

        public HotelViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


    @Override
    public int getContent() {
        return R.layout.act_hotel;
    }

    @Override
    public String getActionBarTitle() {
        return "酒店宾馆";
    }
}
