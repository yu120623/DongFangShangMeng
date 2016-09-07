package com.szdfc.dfsm.fragment;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baseandroid.fragment.BaseFragment;
import com.szdfc.dfsm.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MeFragment extends BaseFragment {


    @Bind(R.id.navigation_view)
    NavigationView navigationView;

    @Override
    protected void initViews() {
        View view = inflater.inflate(R.layout.header_me_frag,null,false);
        navigationView.addHeaderView(view);
    }

    @Override
    protected int getContentView() {
        return R.layout.frag_me;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
