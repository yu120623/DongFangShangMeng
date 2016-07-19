package com.szdfc.dfsm.food.activity;

import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.baseandroid.activity.BaseActivity;
import com.baseandroid.recyclerview.RecyclerViewDivider;
import com.baseandroid.util.CommonUtil;
import com.cundong.recyclerview.HeaderAndFooterRecyclerViewAdapter;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.szdfc.dfsm.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import uk.co.senab.photoview.Compat;

/**
 * Created by FreeMason on 2016/7/7.
 */
//美食
public class FoodListActivity extends BaseActivity {
    @Bind(R.id.food_list)
    RecyclerView foodList;

    private FoodAdapter foodAdapter;

    @Override
    protected void initViews() {
        showBackBtn();
        initFoodList();
        initFoodListHeader();
    }

    private void initFoodListHeader() {
        View header = inflater.inflate(R.layout.header_food,null,false);
        HeaderAndFooterRecyclerViewAdapter headerAndFooterRecyclerViewAdapter = new HeaderAndFooterRecyclerViewAdapter(foodAdapter);
        headerAndFooterRecyclerViewAdapter.addHeaderView(header);
        foodList.setAdapter(headerAndFooterRecyclerViewAdapter);
    }

    private void initFoodList() {
        foodAdapter = new FoodAdapter();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        foodList.setLayoutManager(linearLayoutManager);
        foodList.addItemDecoration(new RecyclerViewDivider(context,2));
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

        public FoodViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
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
            ImageLoader.getInstance().displayImage("http://pic36.nipic.com/20131204/13198552_090418166170_2.jpg",holder.foodImage);
            holder.foodAddress.setText("苏州工业园区咖啡店");
            holder.commentCount.setText("评论 5");
            holder.foodName.setText("北京烤鸭");
            holder.foodTag.setText("北京 烤鸭");
            holder.money.setText("￥280/人");
        }

        @Override
        public int getItemCount() {
            return 10;
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
