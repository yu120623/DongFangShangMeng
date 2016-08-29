package com.szdfc.dfsm.thinktank;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.baseandroid.activity.BaseActivity;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.szdfc.dfsm.R;
import com.szdfc.dfsm.http.API;
import com.szdfc.entitylib.ResultBean;
import com.szdfc.entitylib.ResultListEntity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ThinkTankActivity extends BaseActivity {

    @Bind(R.id.exhibition_recyclerview)
    RecyclerView recyclerView;

    ExhibitionAdapter adapter;

    private List<ResultBean> resultData = new ArrayList<>();

    @Override
    protected void initViews() {
        showBackBtn();
        adapter = new ExhibitionAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        loadDataFromServer();

    }

    private void loadDataFromServer() {
        API.getMainAPI().getThinkTankList(0)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ResultListEntity>() {
                    @Override
                    public void onCompleted() {
                        adapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(ResultListEntity resultListEntity) {
                        resultData = resultListEntity.getResult();
                    }
                });

    }


    class ExhibitionAdapter extends RecyclerView.Adapter<ExhibitionViewHolder> {

        @Override
        public ExhibitionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = inflater.inflate(R.layout.item_exhibition, parent, false);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context,ThinkDetailActivity.class);
                    intent.putExtra("id",(String)view.getTag());
                    startActivity(intent);
                }
            });
            return new ExhibitionViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ExhibitionViewHolder holder, int position) {
            ImageLoader.getInstance().displayImage(resultData.get(position).getResourceEntity().getResourceLocation(), holder.img);
            holder.thinkTitle.setText(resultData.get(position).getTname());
            holder.itemView.setTag(resultData.get(position).getTid()+"");
        }

        @Override
        public int getItemCount() {
            return resultData.size();
        }
    }

    class ExhibitionViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.exh_img)
        ImageView img;
        @Bind(R.id.exh_title)
        TextView thinkTitle;


        public ExhibitionViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


    @Override
    public int getContent() {
        return R.layout.act_exhibition;
    }

    @Override
    public String getActionBarTitle() {
        return "智库";
    }
}
