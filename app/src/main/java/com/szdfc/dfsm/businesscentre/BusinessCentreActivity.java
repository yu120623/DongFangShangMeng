package com.szdfc.dfsm.businesscentre;

import android.support.v7.widget.GridLayoutManager;
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
 * Created by HGo on 2016/8/18.
 */
public class BusinessCentreActivity extends BaseActivity {
    @Bind(R.id.businesscentre_list)
    RecyclerView recyclerView;

    BusinessCentreAdapter adapter;

    List<ResultBean> resultData = new ArrayList<>();


    @Override
    protected void initViews() {
        showBackBtn();

        adapter = new BusinessCentreAdapter();
        recyclerView.setLayoutManager(new GridLayoutManager(context, 2));
        recyclerView.setAdapter(adapter);

        loadDataFromServer();
    }

    private void loadDataFromServer() {
        API.getMainAPI().getBusinessCentreList(0)
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

    class BusinessCentreAdapter extends RecyclerView.Adapter<BusinessCentreViewHolder> {
        @Override
        public BusinessCentreViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = inflater.inflate(R.layout.item_business_centre, parent, false);
            return new BusinessCentreViewHolder(view);
        }

        @Override
        public void onBindViewHolder(BusinessCentreViewHolder holder, int position) {
            ImageLoader.getInstance().displayImage(resultData.get(position).getResourceEntity().getResourceLocation(), holder.img);
            holder.title.setText(resultData.get(position).getBtitle());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        }

        @Override
        public int getItemCount() {
            return resultData.size();
        }
    }

    class BusinessCentreViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.businesscentre_img)
        ImageView img;

        @Bind(R.id.businesscentre_title)
        TextView title;

        public BusinessCentreViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @Override
    public int getContent() {
        return R.layout.act_business_centre;
    }

    @Override
    public String getActionBarTitle() {
        return "商务中心";
    }
}
