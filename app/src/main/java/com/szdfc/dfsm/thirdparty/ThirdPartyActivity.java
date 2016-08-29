package com.szdfc.dfsm.thirdparty;

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

/**
 * Created by HGo on 2016/8/16.
 */
public class ThirdPartyActivity extends BaseActivity {
    @Bind(R.id.third_list)
    RecyclerView recyclerView;

    ThirdPartyAdapter adapter;

    List<ResultBean> resultData = new ArrayList<>();

    @Override
    protected void initViews() {
        showBackBtn();

        adapter = new ThirdPartyAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(adapter);

        loadDataFromServer();
    }

    private void loadDataFromServer() {
        API.getMainAPI().getThirdList(0)
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


    class ThirdPartyAdapter extends RecyclerView.Adapter<ThirdPartyViewHolder> {
        @Override
        public ThirdPartyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = inflater.inflate(R.layout.item_third, parent, false);
            return new ThirdPartyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ThirdPartyViewHolder holder, int position) {
            holder.title.setText(resultData.get(position).getTname());
            holder.desc.setText(resultData.get(position).getTdesc());
            holder.url.setText(resultData.get(position).getTurl());
            ImageLoader.getInstance().displayImage(resultData.get(position).getResourceEntity().getResourceLocation(), holder.img);
        }

        @Override
        public int getItemCount() {
            return resultData.size();
        }
    }

    class ThirdPartyViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.thd_desc)
        TextView desc;
        @Bind(R.id.thd_img)
        ImageView img;
        @Bind(R.id.thd_title)
        TextView title;
        @Bind(R.id.thd_url)
        TextView url;

        public ThirdPartyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @Override
    public int getContent() {
        return R.layout.act_third;
    }

    @Override
    public String getActionBarTitle() {
        return "服务平台";
    }
}
