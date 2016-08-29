package com.szdfc.dfsm.competition;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.baseandroid.activity.BaseActivity;
import com.baseandroid.util.CommonUtil;
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

/**
 * Created by HGo on 2016/8/23.
 */
public class CompetitionActivity extends BaseActivity {
    @Bind(R.id.competition_list)
    RecyclerView recyclerView;
    CompetitionAdapter adapter;

    List<ResultBean> resultData = new ArrayList<>();

    @Override
    protected void initViews() {
        showBackBtn();
        adapter = new CompetitionAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(adapter);
        loadDataFromServer();
    }

    private void loadDataFromServer() {
        API.getMainAPI().getCompetitionList(0)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ResultListEntity>() {
                    @Override
                    public void onCompleted() {
                        adapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(ResultListEntity resultListEntity) {
                        resultData = resultListEntity.getResult();
                    }
                });

    }


    class CompetitionAdapter extends RecyclerView.Adapter<CompetitionViewHolder> {
        @Override
        public CompetitionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = inflater.inflate(R.layout.item_competition, parent, false);
            return new CompetitionViewHolder(view);
        }

        @Override
        public void onBindViewHolder(CompetitionViewHolder holder, int position) {
            if (resultData.get(position).getResourceEntity() != null)
                ImageLoader.getInstance().displayImage(resultData.get(position).getResourceEntity().getResourceLocation(), holder.img);

        }

        @Override
        public int getItemCount() {
            return resultData.size();
        }
    }

    class CompetitionViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.competition_img)
        ImageView img;

        public CompetitionViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @Override
    public int getContent() {
        return R.layout.act_competition;
    }

    @Override
    public String getActionBarTitle() {
        return "创业大赛";
    }
}
