package com.szdfc.dfsm;

import com.baseandroid.activity.BaseActivity;

/**
 * Created by HGo on 2016/7/13.
 */
public class HotelActivity extends BaseActivity {
    @Override
    protected void initViews() {
        showBackBtn();

    }

    @Override
    public int getContent() {
        return R.layout.act_hotel;
    }

    @Override
    public String getActionBarTitle() {
        return null;
    }
}
