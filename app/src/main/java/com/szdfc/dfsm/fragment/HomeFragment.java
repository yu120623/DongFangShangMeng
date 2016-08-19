package com.szdfc.dfsm.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.baseandroid.fragment.BaseFragment;
import com.baseandroid.util.CommonUtil;
import com.cundong.recyclerview.HeaderAndFooterRecyclerViewAdapter;
import com.cundong.recyclerview.RecyclerViewUtils;
import com.szdfc.dfsm.R;
import com.szdfc.dfsm.action.ActionsActivity;
import com.szdfc.dfsm.businesscentre.BusinessCentreActivity;
import com.szdfc.dfsm.businessschool.BusinessSchoolActivity;
import com.szdfc.dfsm.studytour.StudyTourActivity;
import com.szdfc.dfsm.thinktank.ThinkTankActivity;
import com.szdfc.dfsm.food.activity.FoodListActivity;
import com.szdfc.dfsm.gps.NaviActivity;
import com.szdfc.dfsm.news.NewsActivity;
import com.szdfc.dfsm.thirdparty.ThirdPartyActivity;
import com.szdfc.dfsm.tourism.activity.TourismActivity;
import com.szdfc.dfsm.travel.TravelActivity;
import com.szdfc.dfsm.weather.activity.WeatherActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by HGo on 2016/8/3.
 */
public class HomeFragment extends BaseFragment {

    public static final String TAG = "HomeFragment";

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
        }
    };


    GridAdapter adapter;
    View header;

    int[] iconID = new int[]{R.mipmap.icon01,
            R.mipmap.icon02,
            R.mipmap.icon03,
            R.mipmap.icon04,
            R.mipmap.icon05,
            R.mipmap.icon06,
            R.mipmap.icon07,
            R.mipmap.icon08,
            R.mipmap.icon09,
            R.mipmap.icon10,
            R.mipmap.icon11,
            R.mipmap.icon12,
            R.mipmap.icon13,
            R.mipmap.icon14,
            R.mipmap.icon15,
            R.mipmap.icon16};

    String[] title = new String[]{"天气", "航班查询", "高铁动车", "大巴直通车",
            "地图导航", "餐饮", "周边游", "游学",
            "时尚中心", "智库信息", "商学院", "商务中心",
            "新闻资讯", "服务平台", "活动信息", "创业大赛"};


    @Override
    protected void initViews() {

        initHeader();

    }

    private void initHeader() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 4);

        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (position == 0)
                    return 4;
                else
                    return 1;
            }
        });
        recyclerView.setLayoutManager(gridLayoutManager);
        header = inflater.inflate(R.layout.header_main_activity, null, false);
        adapter = new GridAdapter();
        HeaderAndFooterRecyclerViewAdapter headerAdapter = new HeaderAndFooterRecyclerViewAdapter(adapter);
        recyclerView.setAdapter(headerAdapter);

        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, CommonUtil.getScreenHeight(wm) / 3);
        header.setLayoutParams(lp);

        RecyclerViewUtils.setHeaderView(recyclerView, header);
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                int pos = parent.getChildLayoutPosition(view);
                if (pos % 4 == 1) {
                    outRect.right = 2;
                    outRect.bottom = 2;
                } else if (pos % 4 == 2) {
                    outRect.right = 2;
                    outRect.bottom = 2;
                } else if (pos % 4 == 3) {
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
            LayoutInflater inflater = getActivity().getLayoutInflater();
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

    View.OnClickListener itemClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int index = (int) v.getTag();
            Intent intent = null;
            switch (index) {
                case 0:
                    intent = new Intent(context, WeatherActivity.class);
                    break;
                case 1:
                    intent = new Intent(context, TravelActivity.class);
                    intent.putExtra("index", index);
                    break;
                case 2:
                    intent = new Intent(context, TravelActivity.class);
                    intent.putExtra("index", index);
                    break;
                case 3:
                    intent = new Intent(context, TravelActivity.class);
                    intent.putExtra("index", index);
                    break;
                case 4:
                    intent = new Intent(context, NaviActivity.class);
                    break;
                case 5:
                    intent = new Intent(context, FoodListActivity.class);
                    break;
                case 6:
                    intent = new Intent(context, TourismActivity.class);
                    break;
                case 7:
                    intent = new Intent(context, StudyTourActivity.class);
                    break;
                case 8:
                    break;
                case 9:
                    intent = new Intent(context, ThinkTankActivity.class);
                    break;
                case 10:
                    intent = new Intent(context, BusinessSchoolActivity.class);
                    break;
                case 11:
                    intent = new Intent(context, BusinessCentreActivity.class);
                    break;
                case 12:
                    intent = new Intent(context, NewsActivity.class);
                    break;
                case 13:
                    intent = new Intent(context, ThirdPartyActivity.class);
                    break;
                case 14:
                    intent = new Intent(context, ActionsActivity.class);
                    break;
            }
            if (intent != null) {
                startActivity(intent);
            }
        }
    };


    @Override
    protected int getContentView() {
        return R.layout.frag_home;
    }
}
