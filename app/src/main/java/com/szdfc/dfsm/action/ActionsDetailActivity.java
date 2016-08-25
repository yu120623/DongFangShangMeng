package com.szdfc.dfsm.action;

import android.os.Bundle;
import android.support.v7.view.menu.ShowableListMenu;
import android.webkit.WebView;
import android.widget.TextView;

import com.baseandroid.activity.BaseActivity;
import com.baseandroid.util.CommonUtil;
import com.szdfc.dfsm.R;
import com.szdfc.dfsm.http.API;
import com.szdfc.entitylib.ActionDetailEntity;
import com.szdfc.entitylib.NewsDetailEntity;

import java.text.SimpleDateFormat;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

/**
 * Created by FreeMason on 2016/8/25.
 */
public class ActionsDetailActivity extends BaseActivity {
    @Bind(R.id.action_title)
    TextView actionTitle;
    @Bind(R.id.action_time)
    TextView actionTime;
    @Bind(R.id.web_view)
    WebView webView;
    private SimpleDateFormat simpleDateFormat;

    @Override
    protected void initViews() {
        showBackBtn();
        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String id = this.getIntent().getStringExtra("id");
        API.getMainAPI().actFindOne(id)
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        showProgress();
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ActionDetailEntity>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(ActionDetailEntity actionDetailEntity) {
                        show(actionDetailEntity);
                    }
                });
    }

    private void show(ActionDetailEntity actionDetailEntity) {
        hideProgressStatusLayout();
        actionTitle.setText(actionDetailEntity.getResult().getConTitle());
        actionTime.setText("活动日期："+simpleDateFormat.format(actionDetailEntity.getResult().getStartTime())+"~"+simpleDateFormat.format(actionDetailEntity.getResult().getEndTime()));
        webView.loadData(CommonUtil.getHtmlData(actionDetailEntity.getResult().getConContent()), "text/html; charset=utf-8", "utf-8");
    }

    @Override
    public int getContent() {
        return R.layout.act_action_detail;
    }

    @Override
    public String getActionBarTitle() {
        return "活动详细";
    }

}
