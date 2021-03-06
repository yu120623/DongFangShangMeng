package com.szdfc.dfsm.thinktank;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.TextView;

import com.baseandroid.activity.BaseActivity;
import com.baseandroid.util.CommonUtil;
import com.szdfc.dfsm.R;
import com.szdfc.dfsm.http.API;
import com.szdfc.entitylib.ThinkDetailEntity;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

/**
 * Created by HGo on 2016/8/12.
 */
public class ThinkDetailActivity extends BaseActivity {
    @Bind(R.id.think_title)
    TextView thinkTitle;
    @Bind(R.id.web_view)
    WebView webView;

    @Override
    protected void initViews() {
        showBackBtn();
        String id = this.getIntent().getStringExtra("id");
        API.getMainAPI().thinkTankFindOne(id)
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        showProgress();
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ThinkDetailEntity>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(ThinkDetailEntity thinkDetailEntity) {
                        show(thinkDetailEntity);
                    }
                });
    }

    private void show(ThinkDetailEntity thinkDetailEntity) {
        hideProgressStatusLayout();
        thinkTitle.setText(thinkDetailEntity.getResult().getTname());
        webView.loadData(CommonUtil.getHtmlData(thinkDetailEntity.getResult().getTintro()), "text/html; charset=utf-8", "utf-8");
    }

    @Override
    public int getContent() {
        return R.layout.act_think_detail;
    }

    @Override
    public String getActionBarTitle() {
        return "智库详情";
    }

}
