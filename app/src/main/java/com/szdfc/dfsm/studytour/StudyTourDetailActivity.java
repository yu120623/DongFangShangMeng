package com.szdfc.dfsm.studytour;

import android.os.Build;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

import com.baseandroid.activity.BaseActivity;
import com.baseandroid.util.CommonUtil;
import com.szdfc.dfsm.R;
import com.szdfc.dfsm.http.API;
import com.szdfc.entitylib.StudyTourDetailEntity;

import java.text.SimpleDateFormat;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

/**
 * Created by FreeMason on 2016/8/23.
 */
public class StudyTourDetailActivity extends BaseActivity {
    @Bind(R.id.study_title)
    TextView studyTitle;
    @Bind(R.id.study_time)
    TextView studyTime;
    @Bind(R.id.study_address)
    TextView studyAddress;
    @Bind(R.id.web_view)
    WebView webView;

    @Override
    protected void initViews() {
        showBackBtn();
        String id = getIntent().getStringExtra("id");
        API.getMainAPI().studyTourFindOne(id)
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        showProgress();
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<StudyTourDetailEntity>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(StudyTourDetailEntity studyTourDetailEntity) {
                        hideProgressStatusLayout();
                        showInfo(studyTourDetailEntity);
                    }
                });

    }

    private void showInfo(StudyTourDetailEntity studyTourDetailEntity) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("MM月dd日");
        webView.getSettings().setDefaultTextEncodingName("utf-8");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.TEXT_AUTOSIZING);
        } else {
            webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
        }
        webView.loadData(CommonUtil.getHtmlData(studyTourDetailEntity.getResult().getSintro()), "text/html; charset=utf-8", "utf-8");
        studyTime.setText("活动时间："+simpleDateFormat.format(studyTourDetailEntity.getResult().getSstartTime())+"至"+simpleDateFormat2.format(studyTourDetailEntity.getResult().getSendTime()));
        studyTitle.setText(studyTourDetailEntity.getResult().getSname());
        studyAddress.setText(studyTourDetailEntity.getResult().getSaddress());
    }

    @Override
    public int getContent() {
        return R.layout.act_study_tour_detail;
    }

    @Override
    public String getActionBarTitle() {
        return "游学详细";
    }

}
