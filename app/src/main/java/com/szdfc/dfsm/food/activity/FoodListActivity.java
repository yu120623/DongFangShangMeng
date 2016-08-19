package com.szdfc.dfsm.food.activity;

import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.baseandroid.activity.BaseActivity;
import com.baseandroid.recyclerview.RecyclerViewDivider;
import com.baseandroid.util.CommonUtil;
import com.cundong.recyclerview.HeaderAndFooterRecyclerViewAdapter;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.szdfc.dfsm.R;
import com.szdfc.dfsm.http.API;
import com.szdfc.entitylib.CateringEntity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import uk.co.senab.photoview.Compat;

/**
 * Created by FreeMason on 2016/7/7.
 */
//美食
public class FoodListActivity extends BaseActivity implements AMapLocationListener {
    @Bind(R.id.food_list)
    RecyclerView foodList;

    public static final String TAG = "FoodList";

    private FoodAdapter foodAdapter;

    private AMapLocationClient locationClient = null;
    private AMapLocationClientOption locationOption = null;

    List<CateringEntity.ResultBean> data = new ArrayList<>();

    double lat = 0.0;
    double lng = 0.0;

    @Override
    protected void initViews() {
        showBackBtn();
        initFoodList();
        initFoodListHeader();
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

    private void initFoodListHeader() {
        View header = inflater.inflate(R.layout.header_food, null, false);
        HeaderAndFooterRecyclerViewAdapter headerAndFooterRecyclerViewAdapter = new HeaderAndFooterRecyclerViewAdapter(foodAdapter);
        headerAndFooterRecyclerViewAdapter.addHeaderView(header);
        foodList.setAdapter(headerAndFooterRecyclerViewAdapter);
    }

    private void initFoodList() {
        foodAdapter = new FoodAdapter();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        foodList.setLayoutManager(linearLayoutManager);
        foodList.addItemDecoration(new RecyclerViewDivider(context, 1));
    }

    @Override
    public void onLocationChanged(AMapLocation aMapLocation) {
        if (null != aMapLocation) {
            Log.w(TAG, "ErrorCode: " + aMapLocation.getErrorCode() + ", ErrorInfo: " + aMapLocation.getErrorInfo());
            lat = aMapLocation.getLatitude();
            lng = aMapLocation.getLongitude();
            locationClient.stopLocation();
            getFoodData();
        }

    }

    private void getFoodData() {
        API.juHeAPI().getCatering(lng, lat, "2823641ecb879aac3cdb63f2b6b91d7c")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<CateringEntity>() {
                    @Override
                    public void onCompleted() {
                        foodAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(CateringEntity cateringEntity) {
                        data = cateringEntity.getResult();
                    }
                });


    }

    class FoodViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.food_name)
        TextView foodName;
        @Bind(R.id.comment_count)
        TextView commentCount;
        @Bind(R.id.money)
        TextView money;
        @Bind(R.id.food_tag)
        TextView foodTag;
        @Bind(R.id.food_address)
        TextView foodAddress;
        @Bind(R.id.food_img)
        ImageView foodImage;
        @Bind(R.id.food_star)
        RatingBar foodStar;

        public FoodViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    class FoodAdapter extends RecyclerView.Adapter<FoodViewHolder> {

        @Override
        public FoodViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = inflater.inflate(R.layout.item_food, parent, false);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
            return new FoodViewHolder(view);
        }

        @Override
        public void onBindViewHolder(FoodViewHolder holder, int position) {
            String[] tmp = data.get(position).getNavigation().split(">>");
            ImageLoader.getInstance().displayImage(data.get(position).getPhotos(), holder.foodImage);

            holder.foodAddress.setText(data.get(position).getArea());

            holder.commentCount.setText(CommonUtil.isEmpty(data.get(position).getAll_remarks()) ? "暂无评价" : data.get(position).getAll_remarks() + "条评价");
            holder.foodName.setText(data.get(position).getName());
            holder.foodTag.setText(tmp[tmp.length - 2]);
            holder.money.setText("￥" + data.get(position).getAvg_price());
            holder.foodStar.setRating(Float.parseFloat(data.get(position).getStars()));
        }

        @Override
        public int getItemCount() {
            if (data.size() <= 0) return 0;
            return data.size();
        }
    }

    @Override
    public int getContent() {
        return R.layout.act_foot;
    }

    @Override
    public String getActionBarTitle() {
        return "美食";
    }
}
