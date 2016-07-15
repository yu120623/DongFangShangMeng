package com.szdfc.dfsm.tourism.activity;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.baseandroid.activity.BaseActivity;
import com.baseandroid.recyclerview.RecyclerViewDivider;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.szdfc.dfsm.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by FreeMason on 2016/7/12.
 */
public class TourismActivity extends BaseActivity {

    @Bind(R.id.tourism_list)
    RecyclerView tourismList;

    private TourismAdapter tourismAdapter;

    @Override
    protected void initViews() {
        showBackBtn();
        initTourismList();
        initTitle();
    }

    private void initTitle() {
        actionBarTitle.setVisibility(View.VISIBLE);
        actionBarTitle.setText("苏州");
        actionBarTitle.setCompoundDrawables(null,null, ContextCompat.getDrawable(context,R.mipmap.s),null);
    }

    private void initTourismList() {
        tourismAdapter = new TourismAdapter();
        tourismList.setLayoutManager(new LinearLayoutManager(context));
        tourismList.setAdapter(tourismAdapter);
    }

    class TourismAdapter extends RecyclerView.Adapter<TourismViewHolder> {

        @Override
        public TourismViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = inflater.inflate(R.layout.item_tourism, parent, false);
            return new TourismViewHolder(view);
        }

        @Override
        public void onBindViewHolder(TourismViewHolder holder, int position) {
            ImageLoader.getInstance().displayImage("http://pic19.nipic.com/20120311/8103308_192031560168_2.jpg",holder.tourismImg);

        }

        @Override
        public int getItemCount() {
            return 10;
        }
    }

    class TourismViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.tourism_img)
        ImageView tourismImg;
        @Bind(R.id.tourism_name)
        TextView tourismName;
        @Bind(R.id.rating_number)
        TextView ratingNumber;
        @Bind(R.id.charge)
        TextView charge;
        @Bind(R.id.comment_count)
        TextView commentCount;
        @Bind(R.id.tourism_city)
        TextView tourismCity;
        @Bind(R.id.tourism_distance)
        TextView tourismDistance;

        public TourismViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    @Override
    public int getContent() {
        return R.layout.act_tourism;
    }

    @Override
    public String getActionBarTitle() {
        return "";
    }
}
