package com.szdfc.dfsm.fragment;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.baseandroid.fragment.BaseFragment;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.szdfc.dfsm.R;
import com.szdfc.dfsm.exhibition.ExhDetailActivity;
import com.szdfc.dfsm.http.API;
import com.szdfc.entitylib.ExhibitionEntity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by HGo on 2016/8/11.
 */
public class ExhibitionFragment extends BaseFragment {

    @Bind(R.id.exhibition_recyclerview)
    RecyclerView recyclerView;

    ExhibitionAdapter adapter;

    private List<ExhibitionEntity.ResultBean> resultData = new ArrayList<>();

    @Override
    protected void initViews() {
        adapter = new ExhibitionAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        loadDataFromServer();
    }

    private void loadDataFromServer() {
        API.getMainAPI().getExhibition(0)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ExhibitionEntity>() {
                    @Override
                    public void onCompleted() {
                        adapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(ExhibitionEntity exhibitionEntity) {
                        resultData = exhibitionEntity.getResult();
                    }
                });

    }


    class ExhibitionAdapter extends RecyclerView.Adapter<ExhibitionViewHolder> {

        @Override
        public ExhibitionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = inflater.inflate(R.layout.item_exhibition, parent, false);
            return new ExhibitionViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ExhibitionViewHolder holder, int position) {
            ImageLoader.getInstance().displayImage(resultData.get(position).getResourceEntity().getResourceLocation(), holder.bg);
            String sDate = new SimpleDateFormat("M月dd日").format(new Date(resultData.get(position).getEstartDate()));
            String eDate = new SimpleDateFormat("M月dd日").format(new Date(resultData.get(position).getEendDate()));
            holder.date.setText(sDate + "-" + eDate);
            holder.addr.setText(resultData.get(position).getEaddress());

            holder.itemView.setTag(position);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = (int) view.getTag();
                    Intent intent = new Intent(context, ExhDetailActivity.class);
                    intent.putExtra("eid", resultData.get(position).getEid());
                    startActivity(intent);
                }
            });

        }


        @Override
        public int getItemCount() {
            return resultData.size();
        }
    }

    class ExhibitionViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.exhibition_bg)
        ImageView bg;

        @Bind(R.id.s_e_date)
        TextView date;

        @Bind(R.id.exh_addr)
        TextView addr;

        public ExhibitionViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


    @Override
    protected int getContentView() {
        return R.layout.act_exhibition;
    }
}
