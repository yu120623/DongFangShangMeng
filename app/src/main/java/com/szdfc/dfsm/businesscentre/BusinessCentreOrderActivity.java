package com.szdfc.dfsm.businesscentre;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.baseandroid.activity.BaseActivity;
import com.szdfc.dfsm.R;
import com.szdfc.dfsm.http.API;
import com.szdfc.entitylib.ResultBean;
import com.szdfc.entitylib.ResultListEntity;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class BusinessCentreOrderActivity extends BaseActivity {

    @Bind(R.id.order_list)
    RecyclerView recyclerView;

    OrderDateAdapter adapter;

    List<ResultBean> resultData;

    @Override
    protected void initViews() {
        showBackBtn();

        adapter = new OrderDateAdapter();
        recyclerView.setLayoutManager(new GridLayoutManager(context, 4));
        recyclerView.setAdapter(adapter);

        loadDataFromServer();
    }


    private void loadDataFromServer() {
        API.getMainAPI().businessCentreOrderByDate("1470361451000", "1")
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

    class OrderDateAdapter extends RecyclerView.Adapter<OrderDateViewHolder> {
        @Override
        public OrderDateViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = inflater.inflate(R.layout.item_order_date, parent, false);
            return new OrderDateViewHolder(view);
        }

        @Override
        public void onBindViewHolder(OrderDateViewHolder holder, int position) {
            holder.date.setText(resultData.get(position).getTimeSlot());
        }

        @Override
        public int getItemCount() {
            if (resultData == null || resultData.size() <= 0) return 0;
            return resultData.size();
        }
    }

    class OrderDateViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.order_date)
        TextView date;

        public OrderDateViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @Override
    public int getContent() {
        return R.layout.act_business_order;
    }

    @Override
    public String getActionBarTitle() {
        return "预约日期";
    }
}
