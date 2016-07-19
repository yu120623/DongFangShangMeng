package com.szdfc.dfsm;

import com.baseandroid.activity.BaseActivity;

/**
 * Created by HGo on 2016/7/13.
 */
public class BusActivity extends BaseActivity {
    @Override
    protected void initViews() {
        showBackBtn();

    }

    @Override
    public int getContent() {
        return R.layout.act_bus;
    }

    @Override
    public String getActionBarTitle() {
        return "大巴直通车";
    }
}
