package com.szdfc.dfsm.exhibition;

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
import com.szdfc.entitylib.ExhibitionEntity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by HGo on 2016/7/11.
 */
public class ExhibitionActivity extends BaseActivity {

    @Bind(R.id.exhibition_recyclerview)
    RecyclerView recyclerView;

    ExhibitionAdapter adapter;

    private List<ExhibitionEntity.ResultBean> resultData = new ArrayList<>();

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
           // holder.title.setText(resultData.get(position).getEtitle());
        }


        @Override
        public int getItemCount() {
            return resultData.size();
        }
    }

    class ExhibitionViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.exhibition_bg)
        ImageView bg;

//        @Bind(R.id.exhibition_title)
//        TextView title;

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
        return "展会";
    }
}
