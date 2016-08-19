package com.szdfc.dfsm.travel;

import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.baseandroid.activity.BaseActivity;
import com.baseandroid.recyclerview.RecyclerViewDivider;
import com.baseandroid.util.CommonUtil;
import com.szdfc.dfsm.R;
import com.szdfc.dfsm.http.API;
import com.szdfc.entitylib.PlanEntity;
import com.szdfc.entitylib.TrainEntity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class ResultActivity extends BaseActivity {

    @Bind(R.id.result_list)
    RecyclerView recyclerView;

    ResultAdapter adapter;

    List<PlanEntity.ResultBean> planEntityData = new ArrayList<>();
    List<TrainEntity.ResultBean.ResultList> trainEntityData = new ArrayList<>();

    String start = "上海南";
    String end = "苏州";
    int index = 0;

    @Override
    protected void initViews() {
        showBackBtn();

//        start = getIntent().getStringExtra("start");
//        end = getIntent().getStringExtra("end");
        index = getIntent().getIntExtra("index", 0);


        adapter = new ResultAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.addItemDecoration(new RecyclerViewDivider(context, 1));
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        switch (index) {
            case 1:
                getPlanData();
                break;
            case 2:
                getTrainData();
                break;
        }


    }

    class ResultAdapter extends RecyclerView.Adapter<ResultViewHolder> {
        @Override
        public ResultViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = null;
            switch (index) {
                case 1:
                    view = inflater.inflate(R.layout.item_flt, parent, false);
                    break;
                case 2:
                    view = inflater.inflate(R.layout.item_train, parent, false);
                    break;
                case 3:
                    view = inflater.inflate(R.layout.item_bus, parent, false);
                    break;
            }
            //View view = inflater.inflate(R.layout.item_flt, parent, false);
            return new ResultViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ResultViewHolder holder, int position) {
            switch (index) {
                case 1:
                    holder.depTime.setText(planEntityData.get(position).getDepTime());
                    holder.arrTime.setText(planEntityData.get(position).getArrTime());
                    holder.depCode.setText(planEntityData.get(position).getDepCode() + planEntityData.get(position).getDepTerminal());
                    holder.arrCode.setText(planEntityData.get(position).getArrCode() + planEntityData.get(position).getArrTerminal());
                    holder.arrLine.setText(planEntityData.get(position).getAirline());
                    holder.timeRate.setText(CommonUtil.isEmpty(planEntityData.get(position).getOnTimeRate()) ? "noData" : planEntityData.get(position).getOnTimeRate());
                    break;
                case 2:
                    holder.startTime.setText(trainEntityData.get(position).getStart_time());
                    holder.startStation.setText(trainEntityData.get(position).getStart_station());
                    holder.endStation.setText(trainEntityData.get(position).getEnd_station());
                    holder.endTime.setText(trainEntityData.get(position).getEnd_time());
                    holder.runTime.setText(trainEntityData.get(position).getRun_time());
                    holder.trainNo.setText(trainEntityData.get(position).getTrain_no());
                    break;
            }
//            holder.depTime.setText(planEntityData.get(position).getDepTime());
//            holder.arrTime.setText(planEntityData.get(position).getArrTime());
//            holder.depCode.setText(planEntityData.get(position).getDepCode() + planEntityData.get(position).getDepTerminal());
//            holder.arrCode.setText(planEntityData.get(position).getArrCode() + planEntityData.get(position).getArrTerminal());
//            holder.arrLine.setText(planEntityData.get(position).getAirline());
//            holder.timeRate.setText(CommonUtil.isEmpty(planEntityData.get(position).getOnTimeRate()) ? "noData" : planEntityData.get(position).getOnTimeRate());
        }

        @Override
        public int getItemCount() {
            if (index == 1) {
                if (planEntityData.size() > 0)
                    return planEntityData.size();
                else
                    return 0;
            } else if (index == 2) {
                if (trainEntityData.size() > 0)
                    return trainEntityData.size();
                else
                    return 0;
            } else if (index == 3) {
//                if (trainEntityData.size() > 0)
//                    return trainEntityData.size();
//                else
//                    return 0;
                return 10;
            } else
                return 0;
        }
    }

    private void getPlanData() {
        API.juHeAPI().getPlanBC(start, end, "", "87df352f9bfcca134abb76151936dc27")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<PlanEntity>() {
                    @Override
                    public void onCompleted() {
                        adapter.notifyDataSetChanged();

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(PlanEntity planEntity) {
                        //planEntityData = planEntity.getResult();
                    }
                });
    }

    private void getTrainData() {
        API.juHeAPI().getTrainList("1ad4bdb773ff2255372641fe31eed702", start, end)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<TrainEntity>() {
                    @Override
                    public void onCompleted() {
                        adapter.notifyDataSetChanged();

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(TrainEntity trainEntity) {
                        trainEntityData = trainEntity.getResult().getList();
                    }
                });

    }

    class ResultViewHolder extends RecyclerView.ViewHolder {
        @Nullable
        @Bind(R.id.dep_time)
        TextView depTime;
        @Nullable
        @Bind(R.id.depcode_terminal)
        TextView depCode;
        @Nullable
        @Bind(R.id.arr_time)
        TextView arrTime;
        @Nullable
        @Bind(R.id.arrcode_terminal)
        TextView arrCode;
        @Nullable
        @Bind(R.id.ontimerate)
        TextView timeRate;
        @Nullable
        @Bind(R.id.arrline_fltnum)
        TextView arrLine;

        @Nullable
        @Bind(R.id.start_time)
        TextView startTime;
        @Nullable
        @Bind(R.id.end_time)
        TextView endTime;
        @Nullable
        @Bind(R.id.start_station)
        TextView startStation;
        @Nullable
        @Bind(R.id.end_station)
        TextView endStation;
        @Nullable
        @Bind(R.id.train_no)
        TextView trainNo;
        @Nullable
        @Bind(R.id.run_time)
        TextView runTime;


        public ResultViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @Override
    public int getContent() {
        return R.layout.act_result;
    }

    @Override
    public String getActionBarTitle() {
        return null;
    }
}
