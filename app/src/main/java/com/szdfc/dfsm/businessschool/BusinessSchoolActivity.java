package com.szdfc.dfsm.businessschool;

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
import com.szdfc.entitylib.BusinessSchoolEneity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class BusinessSchoolActivity extends BaseActivity {

    @Bind(R.id.businessschool_list)
    RecyclerView recyclerView;

    BusinessSchoolAdapter adapter;
    List<BusinessSchoolEneity.ResultBean> resultData = new ArrayList<>();

    @Override
    protected void initViews() {
        showBackBtn();

        adapter = new BusinessSchoolAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(adapter);

        loadDataFromServer();
    }

    private void loadDataFromServer() {
        API.getMainAPI().getbSchoolList(0)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<BusinessSchoolEneity>() {
                    @Override
                    public void onCompleted() {
                        adapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(BusinessSchoolEneity businessSchoolEneity) {
                        resultData = businessSchoolEneity.getResult();
                    }


                });

    }

    class BusinessSchoolAdapter extends RecyclerView.Adapter<BusinessSchoolViewHolder> {
        @Override
        public BusinessSchoolViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = inflater.inflate(R.layout.item_studyour, parent, false);
            return new BusinessSchoolViewHolder(view);
        }

        @Override
        public void onBindViewHolder(BusinessSchoolViewHolder holder, int position) {
            ImageLoader.getInstance().displayImage(resultData.get(position).getResourceEntity().getResourceLocation(), holder.img);
            holder.title.setText(resultData.get(position).getBdesc());
            holder.desc.setText(resultData.get(position).getBshare());
        }

        @Override
        public int getItemCount() {
            return resultData.size();
        }
    }

    class BusinessSchoolViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.sty_img)
        ImageView img;
        @Bind(R.id.sty_title)
        TextView title;
        @Bind(R.id.sty_desc)
        TextView desc;

        public BusinessSchoolViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @Override
    public int getContent() {
        return R.layout.act_businessschool;
    }

    @Override
    public String getActionBarTitle() {
        return "商学院";
    }
}
