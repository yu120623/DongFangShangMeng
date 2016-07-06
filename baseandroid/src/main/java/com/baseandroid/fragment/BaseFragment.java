package com.baseandroid.fragment;

import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.baseandroid.R;
import com.baseandroid.activity.BaseActivity;

import butterknife.ButterKnife;
import rx.Subscription;

/**
 * Created by FreeMason on 2016/4/25.
 */
public abstract class BaseFragment extends Fragment {
    protected Context context;
    protected BaseActivity activity;
    protected LayoutInflater inflater;
    protected View contentView;
    protected RelativeLayout view;//缓存Fragment view
    protected Subscription subscription;
    protected SharedPreferences sp;

    TextView progressText;
    TextView failedText;
    TextView noDataText;

    View progressLayout;
    View failedLayout;
    View noDataLayout;
    View layoutProgressStatus;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.inflater = inflater;
        if (view == null || !isCacheView()) {
            view = (RelativeLayout) inflater.inflate(R.layout.base_fragment, container, false);
            contentView = inflater.inflate(getContentView(), container, false);
            view.addView(contentView, new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT));
            init();
            initViews();
        }
        ViewGroup parent = (ViewGroup) view.getParent();
        if (parent != null) {
            parent.removeView(view);
        }
        return view;
    }

    protected void init() {
        context = this.getActivity().getApplicationContext();
        activity = (BaseActivity) this.getActivity();
        sp = context.getSharedPreferences("app", Context.MODE_PRIVATE);
        ButterKnife.bind(this,contentView);
        initProgressLayout();
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

    protected abstract int getContentView();


    protected boolean isCacheView() {
        return true;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unSubscribe();
    }

    //释放资源
    protected void unSubscribe() {
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }

    protected View findViewById(int id) {
        return view.findViewById(id);
    }


    //显示失败layout
    protected void showFailed() {
        failedLayout.setVisibility(View.VISIBLE);
        failedText.setVisibility(View.GONE);
        progressLayout.setVisibility(View.GONE);
        noDataLayout.setVisibility(View.GONE);
        layoutProgressStatus.setVisibility(View.VISIBLE);
    }

    protected void showNoData() {
        failedLayout.setVisibility(View.GONE);
        progressLayout.setVisibility(View.GONE);
        noDataLayout.setVisibility(View.VISIBLE);
        noDataText.setVisibility(View.GONE);
        layoutProgressStatus.setVisibility(View.VISIBLE);
    }

    protected void showProgress() {
        failedLayout.setVisibility(View.GONE);
        progressLayout.setVisibility(View.VISIBLE);
        progressText.setVisibility(View.GONE);
        noDataLayout.setVisibility(View.GONE);
        layoutProgressStatus.setVisibility(View.VISIBLE);
    }

    protected void hideProgressStatusLayout() {
        failedLayout.setVisibility(View.GONE);
        progressLayout.setVisibility(View.GONE);
        noDataLayout.setVisibility(View.GONE);
        layoutProgressStatus.setVisibility(View.GONE);
    }

    protected void showNoData(String noDataString) {
        showNoData();
        noDataText.setText(noDataString);
        noDataText.setVisibility(View.VISIBLE);
    }

    protected void showProgress(String noDataString) {
        showProgress();
        progressText.setText(noDataString);
        progressText.setVisibility(View.VISIBLE);
    }

    protected void showFailed(String noDataString) {
        showFailed();
        failedText.setText(noDataString);
        failedText.setVisibility(View.VISIBLE);
    }

}
