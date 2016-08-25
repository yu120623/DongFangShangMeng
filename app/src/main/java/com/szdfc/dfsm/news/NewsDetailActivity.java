package com.szdfc.dfsm.news;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.baseandroid.activity.BaseActivity;
import com.baseandroid.util.CommonUtil;
import com.szdfc.dfsm.R;
import com.szdfc.dfsm.http.API;
import com.szdfc.entitylib.NewsDetailEntity;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

/**
 * Created by FreeMason on 2016/8/25.
 */
public class NewsDetailActivity extends BaseActivity {

    @Bind(R.id.news_title)
    TextView newsTitle;
    @Bind(R.id.web_view)
    WebView webView;

    @Override
    protected void initViews() {
        showBackBtn();
        String id = this.getIntent().getStringExtra("id");
        API.getMainAPI().newsFindOne(id)
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        showProgress();
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<NewsDetailEntity>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(NewsDetailEntity newsDetailEntity) {
                        show(newsDetailEntity);
                    }
                });
    }

    private void show(NewsDetailEntity newsDetailEntity) {
        hideProgressStatusLayout();
        newsTitle.setText(newsDetailEntity.getResult().getNtitle());
        webView.loadData(CommonUtil.getHtmlData(newsDetailEntity.getResult().getNcontent()), "text/html; charset=utf-8", "utf-8");
    }

    @Override
    public int getContent() {
        return R.layout.act_news_detail;
    }

    @Override
    public String getActionBarTitle() {
        return "新闻详细";
    }

}
