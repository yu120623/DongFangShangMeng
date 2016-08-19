package com.szdfc.dfsm.action;

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
import com.szdfc.entitylib.ActionEntity;

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
 * Created by HGo on 2016/8/16.
 */
public class ActionsActivity extends BaseActivity {
    @Bind(R.id.act_list)
    RecyclerView recyclerView;

    ActionAdapter adapter;

    List<ActionEntity.ResultBean> resultData = new ArrayList<>();

    @Override
    protected void initViews() {
        showBackBtn();

        adapter = new ActionAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(adapter);

        loadDataFromServer();
    }

    private void loadDataFromServer() {
        API.getMainAPI().getActList(0)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ActionEntity>() {
                    @Override
                    public void onCompleted() {
                        adapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(ActionEntity actionEntity) {
                        resultData = actionEntity.getResult();
                    }


                });

    }

    class ActionAdapter extends RecyclerView.Adapter<ActionViewHolder> {
        @Override
        public ActionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = inflater.inflate(R.layout.item_action, parent, false);
            return new ActionViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ActionViewHolder holder, int position) {
            holder.title.setText(resultData.get(position).getConTitle());
            ImageLoader.getInstance().displayImage(resultData.get(position).getResource().getResourceLocation(), holder.img);
            holder.desc.setText(resultData.get(position).getConDesc());
            String sDate = new SimpleDateFormat("M月dd日").format(new Date(resultData.get(position).getStartTime()));
            String eDate = new SimpleDateFormat("M月dd日").format(new Date(resultData.get(position).getEndTime()));
            holder.date.setText(sDate + "-" + eDate);
        }

        @Override
        public int getItemCount() {
            return resultData.size();
        }
    }

    class ActionViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.action_img)
        ImageView img;
        @Bind(R.id.action_title)
        TextView title;
        @Bind(R.id.action_desc)
        TextView desc;
        @Bind(R.id.action_date)
        TextView date;


        public ActionViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }

    @Override
    public int getContent() {
        return R.layout.act_action;
    }

    @Override
    public String getActionBarTitle() {
        return "活动";
    }
}
