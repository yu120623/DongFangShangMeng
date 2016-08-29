package com.szdfc.dfsm.fashioncentre;

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
 * Created by HGo on 2016/8/23.
 */
public class FashionCentreActivity extends BaseActivity {

    @Bind(R.id.fashioncentre_list)
    RecyclerView recyclerView;

    FashionCentreAdapter adapter;
    List<ResultBean> resultData = new ArrayList<>();

    @Override
    protected void initViews() {
        showBackBtn();

        adapter = new FashionCentreAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(adapter);

        loadDataFromServer();
    }

    private void loadDataFromServer() {
        API.getMainAPI().getFashionCentreList(0)
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


    class FashionCentreAdapter extends RecyclerView.Adapter<FashionCentreViewHolder> {
        @Override
        public FashionCentreViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = inflater.inflate(R.layout.item_fashion_centre, parent, false);
            return new FashionCentreViewHolder(view);
        }

        @Override
        public void onBindViewHolder(FashionCentreViewHolder holder, int position) {
            ImageLoader.getInstance().displayImage(resultData.get(position).getResourceEntity().getResourceLocation(), holder.img);
            holder.addr.setText(resultData.get(position).getFtitle());
        }

        @Override
        public int getItemCount() {
            if (resultData.size() <= 0) return 0;
            return resultData.size();
        }
    }

    class FashionCentreViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.fashion_img)
        ImageView img;
        @Bind(R.id.fashion_addr)
        TextView addr;
        @Bind(R.id.fashion_date)
        TextView date;


        public FashionCentreViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @Override
    public int getContent() {
        return R.layout.act_fashion_centre;
    }

    @Override
    public String getActionBarTitle() {
        return "时尚中心";
    }
}
