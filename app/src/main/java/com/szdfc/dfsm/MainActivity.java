package com.szdfc.dfsm;

import android.content.Intent;
import android.graphics.Rect;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.baseandroid.activity.BaseActivity;
import com.cundong.recyclerview.HeaderAndFooterRecyclerViewAdapter;
import com.cundong.recyclerview.RecyclerViewUtils;
import com.szdfc.dfsm.food.activity.FoodListActivity;
import com.szdfc.dfsm.tourism.activity.TourismActivity;
import com.szdfc.dfsm.weather.activity.WeatherActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by HGo on 2016/7/6.
 */
public class MainActivity extends BaseActivity {

    public static final String TAG = "main";

    @Bind(R.id.main_list)
    RecyclerView recyclerView;

    List<View> viewList = new ArrayList<>();

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
            //return super.instantiateItem(container, position);
        }
    };


    GridAdapter adapter;
    View header;

    int[] iconID = new int[]{R.mipmap.a, R.mipmap.b, R.mipmap.c, R.mipmap.d, R.mipmap.e, R.mipmap.f, R.mipmap.g, R.mipmap.h, R.mipmap.i, R.mipmap.j, R.mipmap.k, R.mipmap.l, R.mipmap.m, R.mipmap.n, R.mipmap.o};
    String[] title = new String[]{"天气", "航班查询", "高铁动车", "大巴直通车", "地图导航", "酒店宾馆", "餐饮", "周边游", "展会", "智库信息", "商学院", "游学", "服务平台", "商务中心", "时尚中心"};

    @Override
    protected void initViews() {
        initHeader();
        toolbar.setVisibility(View.GONE);
    }

    private void initHeader() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 3);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (position == 0)
                    return 3;
                else
                    return 1;
            }
        });
        recyclerView.setLayoutManager(gridLayoutManager);
        header = inflater.inflate(R.layout.header_main_activity, null, false);
        adapter = new GridAdapter();
        HeaderAndFooterRecyclerViewAdapter headerAdapter = new HeaderAndFooterRecyclerViewAdapter(adapter);
        recyclerView.setAdapter(headerAdapter);
        RecyclerViewUtils.setHeaderView(recyclerView, header);
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                int pos = parent.getChildLayoutPosition(view);
                if (pos % 3 == 1) {
                    outRect.right = 2;
                    outRect.bottom = 2;
                } else if (pos % 3 == 2) {
                    outRect.right = 2;
                    outRect.bottom = 2;
                } else {
                    outRect.bottom = 2;
                }

            }
        });

        ViewPager viewPager = (ViewPager) header.findViewById(R.id.home_view_page);
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


    class GridAdapter extends RecyclerView.Adapter<GridViewHolder> {

        @Override
        public GridViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = inflater.inflate(R.layout.item_main, parent, false);
            view.setOnClickListener(itemClick);
            return new GridViewHolder(view);
        }

        @Override
        public void onBindViewHolder(GridViewHolder holder, int position) {
            holder.icon.setImageResource((iconID[position]));
            holder.itemView.setTag(position);
            holder.title.setText(title[position]);
        }


        @Override
        public int getItemCount() {
            return iconID.length;
        }
    }

    class GridViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.grid_icon)
        ImageView icon;
        @Bind(R.id.grid_title)
        TextView title;

        public GridViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    View.OnClickListener itemClick = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            int index = (int) v.getTag();
            Intent intent = null;
            switch (index){
                case 0:
                    intent = new Intent(context, WeatherActivity.class);
                    break;
                case 6:
                    intent = new Intent(context, FoodListActivity.class);
                    break;
                case 7:
                    intent = new Intent(context, TourismActivity.class);
                    break;
            }
            if(intent != null){
                startActivity(intent);
            }
        }
    };


    @Override
    public int getContent() {
        return R.layout.activity_main;
    }

    @Override
    public String getActionBarTitle() {
        return null;
    }
}
