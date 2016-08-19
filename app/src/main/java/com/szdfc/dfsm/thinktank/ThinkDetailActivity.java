package com.szdfc.dfsm.thinktank;

import com.baseandroid.activity.BaseActivity;

/**
 * Created by HGo on 2016/8/12.
 */
public class ThinkDetailActivity extends BaseActivity {
    @Override
    protected void initViews() {
        showBackBtn();

    }

    @Override
    public int getContent() {
        return 0;
    }

    @Override
    public String getActionBarTitle() {
        return "智库详情";
    }
}
