package com.baseandroid.activity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baseandroid.R;

import butterknife.ButterKnife;
import rx.Subscription;

/**
 * Created by FreeMason on 2016/4/1.
 */
public abstract class BaseActivity extends AppCompatActivity {
    protected Context context;
    protected Activity activity;
    protected LayoutInflater inflater;
    protected Subscription subscription;
    protected View view;
    protected Toolbar toolbar;
    ViewGroup content;
    protected SharedPreferences sp;

    View progressLayout;
    View failedLayout;
    View noDataLayout;
    View layoutProgressStatus;
    TextView progressText;
    TextView failedText;
    TextView noDataText;
    protected TextView actionBarTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_activity);
        initSymbol();
        initContentView();
        initProgressLayout();
        ButterKnife.bind(this);
        initActionBar();
        initViews();
        if(isShowNetInfo())
            showNetInfo();
    }

    protected void initProgressLayout(){
        progressLayout = this.findViewById(R.id.progress_layout);
        failedLayout = this.findViewById(R.id.failed_layout);
        noDataLayout = this.findViewById(R.id.no_data_layout);
        layoutProgressStatus = this.findViewById(R.id.layout_progress_status);
        progressText = (TextView) this.findViewById(R.id.progress_text);
        failedText = (TextView) this.findViewById(R.id.failed_text);
        noDataText = (TextView) this.findViewById(R.id.no_data_text);
    };

    protected abstract void initViews();

    private void initActionBar() {
        setSupportActionBar(toolbar);
        actionBarTitle = (TextView) this.findViewById(R.id.toolbar_title);
        toolbar.setTitle(getActionBarTitle());
        getSupportActionBar().setTitle(getActionBarTitle());
        toolbar.setTitleTextColor(Color.WHITE);
    }

    private void initSymbol() {
        context = this.getApplicationContext();
        activity = this;
        inflater = LayoutInflater.from(context);
        sp = context.getSharedPreferences("yqt", Context.MODE_PRIVATE);

    }


    private void initContentView() {
        content = (ViewGroup) this.findViewById(R.id.content);
        view = inflater.inflate(getContent(), null, false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        view.setLayoutParams(layoutParams);
        content.addView(view);
        toolbar = (Toolbar) this.findViewById(R.id.tool_bar);
    }

    public abstract int getContent();

    public abstract String getActionBarTitle();


    //释放资源
    protected void unSubscribe() {
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }

    protected void showBackBtn() {
        toolbar.setNavigationIcon(R.mipmap.ic_gf_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unSubscribe();
    }

    protected boolean isShowNetInfo(){
        return false;
    }

    private void showNetInfo(){

    }

    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo.State wifiState = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState();
            NetworkInfo.State mobileState = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState();
            if (wifiState != null && mobileState != null
                    && NetworkInfo.State.CONNECTED != wifiState
                    && NetworkInfo.State.CONNECTED == mobileState) {
                // 手机网络连接成功
            } else if (wifiState != null && mobileState != null
                    && NetworkInfo.State.CONNECTED != wifiState
                    && NetworkInfo.State.CONNECTED != mobileState) {
                // 手机没有任何的网络
            } else if (wifiState != null && NetworkInfo.State.CONNECTED == wifiState) {
                // 无线网络连接成功
            }
        }
    };

    //显示失败layout
    protected void showFailed(){
        failedLayout.setVisibility(View.VISIBLE);
        failedText.setVisibility(View.GONE);
        progressLayout.setVisibility(View.GONE);
        noDataLayout.setVisibility(View.GONE);
        layoutProgressStatus.setVisibility(View.VISIBLE);
    }

    protected void showNoData(){
        failedLayout.setVisibility(View.GONE);
        progressLayout.setVisibility(View.GONE);
        noDataLayout.setVisibility(View.VISIBLE);
        noDataText.setVisibility(View.GONE);
        layoutProgressStatus.setVisibility(View.VISIBLE);
    }

    protected void showProgress(){
        failedLayout.setVisibility(View.GONE);
        progressLayout.setVisibility(View.VISIBLE);
        progressText.setVisibility(View.GONE);
        noDataLayout.setVisibility(View.GONE);
        layoutProgressStatus.setVisibility(View.VISIBLE);
    }

    protected void hideProgressStatusLayout(){
        failedLayout.setVisibility(View.GONE);
        progressLayout.setVisibility(View.GONE);
        noDataLayout.setVisibility(View.GONE);
        layoutProgressStatus.setVisibility(View.GONE);
    }

    protected void showNoData(String noDataString){
        showNoData();
        noDataText.setText(noDataString);
        noDataText.setVisibility(View.VISIBLE);
    }

    protected void showProgress(String noDataString){
        showProgress();
        progressText.setText(noDataString);
        progressText.setVisibility(View.VISIBLE);
    }

    protected void showFailed(String noDataString){
        showFailed();
        failedText.setText(noDataString);
        failedText.setVisibility(View.VISIBLE);
    }
}
