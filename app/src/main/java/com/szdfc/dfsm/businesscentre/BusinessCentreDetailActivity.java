package com.szdfc.dfsm.businesscentre;

import com.baseandroid.activity.BaseActivity;
import com.szdfc.dfsm.R;

/**
 * Created by HGo on 2016/8/24.
 */
public class BusinessCentreDetailActivity extends BaseActivity {
    @Override
    protected void initViews() {
        showBackBtn();
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
