package com.szdfc.dfsm.exhibition;

import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.baseandroid.activity.BaseActivity;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.szdfc.dfsm.R;
import com.szdfc.dfsm.http.API;
import com.szdfc.entitylib.ExhDetailEntity;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.Bind;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ExhDetailActivity extends BaseActivity {

    @Bind(R.id.exh_detail_img)
    ImageView img;
    @Bind(R.id.exh_detail_enrol_num)
    TextView enrolNum;
    @Bind(R.id.exh_detail_title)
    TextView title;
    @Bind(R.id.exh_enrol_date)
    TextView date;
    @Bind(R.id.exh_detail_addr)
    TextView addr;
    @Bind(R.id.enrol_btn)
    TextView enrolBtn;

    private ExhDetailEntity.ResultBean resultData;

    @Override
    protected void initViews() {
        showBackBtn();

        loadDataFromServer();
    }

    private void loadDataFromServer() {
        API.getMainAPI().getExhDetail(getIntent().getIntExtra("eid", -1))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ExhDetailEntity>() {
                    @Override
                    public void onCompleted() {
                        showDetail();
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(ExhDetailEntity exhDetailEntity) {
                        resultData = exhDetailEntity.getResult();
                    }


                });


    }

    private void showDetail() {
        title.setText(resultData.getEtitle());
        enrolNum.setText(resultData.getEnrolNum() + "人已经报名");
        String sDate = new SimpleDateFormat("yyyy.M.dd").format(new Date(resultData.getEstartDate()));
        String eDate = new SimpleDateFormat("yyyy.M.dd").format(new Date(resultData.getEendDate()));
        date.setText(sDate + "-" + eDate);
        addr.setText(resultData.getEaddress());
        if (resultData.getCanEnrol().equals("0")) {
            enrolBtn.setText("已报名");
            enrolBtn.setEnabled(false);
        }

    }

    @Override
    public int getContent() {
        return R.layout.act_exh_detail;
    }

    @Override
    public String getActionBarTitle() {
        return "展会详情";
    }
}
