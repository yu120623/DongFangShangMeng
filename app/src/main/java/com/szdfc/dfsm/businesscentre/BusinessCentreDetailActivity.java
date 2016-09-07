package com.szdfc.dfsm.businesscentre;

import android.content.Intent;
import android.widget.TextView;

import com.baseandroid.activity.BaseActivity;
import com.szdfc.dfsm.R;
import com.szdfc.dfsm.http.API;
import com.szdfc.entitylib.ResultBean;
import com.szdfc.entitylib.ResultEntity;

import butterknife.Bind;
import butterknife.OnClick;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class BusinessCentreDetailActivity extends BaseActivity {


    @Bind(R.id.order_title)
    TextView title;
    @Bind(R.id.order_desc)
    TextView desc;

    ResultBean resultData;

    @OnClick(R.id.enrol_btn)
    void order_btn() {
        Intent intent = new Intent();
        intent.setClass(context, BusinessCentreOrderActivity.class);
        intent.putExtra("bid", getIntent().getStringArrayExtra("bid"));
        startActivity(intent);
    }

    @Override
    protected void initViews() {
        showBackBtn();
        loadDataFromServer();
    }

    private void loadDataFromServer() {
        API.getMainAPI().businessCentreFindOne(getIntent().getStringExtra("bid"))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ResultEntity>() {
                    @Override
                    public void onCompleted() {
                        title.setText(resultData.getBtitle());
                        desc.setText(resultData.getBdesc());
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(ResultEntity resultEntity) {
                        resultData = resultEntity.getResult();
                    }
                });

    }


    @Override
    public int getContent() {
        return R.layout.act_businesscentre_detail;
    }

    @Override
    public String getActionBarTitle() {
        return "商务预约";
    }
}
